package com.kira.health.app.data.result

import com.kira.health.app.data.remote.apis.APIModule
import com.kira.health.app.data.remote.apis.models.responses.BaseResponse
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun <T> Response<BaseResponse<T>>.toResult(): Result<T> = runCatching {
    body()?.let {
        it.data?.let { data ->
            return data.toResult()
        }
        return Result.Error.DEFAULT
    }
    return errorBody()?.string()?.let { json ->
        APIModule
            .provideMoshi()
            .adapter(Result.Error::class.java)
            .fromJson(json)
    } ?: Result.Error.DEFAULT
}.getOrElse { it.toError() }

fun Throwable.toError(): Result.Error {
    return when (this) {
        is SocketTimeoutException, is UnknownHostException, is ConnectException -> Result.Error(
            Result.Error.Companion.Code.NETWORK.value,
            localizedMessage ?: toString()
        )

        else -> Result.Error.DEFAULT
    }
}

fun <T> T.toResult(): Result<T> = Result.Success(this)
