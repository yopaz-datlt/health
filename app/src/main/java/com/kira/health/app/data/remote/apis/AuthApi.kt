package com.kira.health.app.data.remote.apis

import com.kira.health.app.data.remote.apis.models.requests.LoginRequest
import com.kira.health.app.data.remote.apis.models.responses.BaseResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<BaseResponse<String>>
}
