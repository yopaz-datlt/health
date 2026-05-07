package com.kira.health.app.data.remote.datasource

import com.kira.health.app.data.remote.apis.UserApi
import com.kira.health.app.data.remote.apis.models.responses.BaseResponse
import com.kira.health.app.domain.models.User
import retrofit2.Response
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val userApi: UserApi
) {
    suspend fun fetchUser(): Response<BaseResponse<User>> {
        return userApi.fetchUser()
    }
}
