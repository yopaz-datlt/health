package com.kira.health.app.data.repositories

import com.kira.health.app.data.local.datasource.AuthLocalDataSource
import com.kira.health.app.data.local.datasource.UserLocalDataSource
import com.kira.health.app.data.remote.apis.models.requests.LoginRequest
import com.kira.health.app.data.remote.datasource.AuthRemoteDataSource
import com.kira.health.app.data.result.Result
import com.kira.health.app.data.result.toResult
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val remoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource,
    private val userLocalDataSource: UserLocalDataSource
) {
    val isLoggedInFlow = authLocalDataSource.tokenFlow.map { it != null }

    suspend fun login(email: String, password: String) =
        remoteDataSource.login(LoginRequest(email, password)).toResult().apply {
            if (this is Result.Success) {
                authLocalDataSource.saveToken(data)
            }
        }

    suspend fun logout() {
        authLocalDataSource.clearToken()
        userLocalDataSource.deleteUser()
    }
}
