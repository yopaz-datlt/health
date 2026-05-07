package com.kira.health.app.data.remote.datasource

import com.kira.health.app.data.remote.apis.AuthApi
import com.kira.health.app.data.remote.apis.models.requests.LoginRequest
import com.kira.health.app.data.remote.apis.models.responses.BaseResponse
import retrofit2.Response
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(
    private val authApi: AuthApi
) {
    suspend fun login(loginRequest: LoginRequest): Response<BaseResponse<String>> {
        return authApi.login(loginRequest)
    }
}
