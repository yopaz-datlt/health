package com.kira.health.app.data.remote.apis

import com.kira.health.app.data.remote.apis.models.responses.BaseResponse
import com.kira.health.app.domain.models.User
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {

    @GET("user")
    suspend fun fetchUser(): Response<BaseResponse<User>>
}
