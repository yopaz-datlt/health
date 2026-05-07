package com.kira.health.app.data.repositories

import com.kira.health.app.data.local.datasource.UserLocalDataSource
import com.kira.health.app.data.remote.datasource.UserRemoteDataSource
import com.kira.health.app.data.result.Result
import com.kira.health.app.data.result.toResult
import com.kira.health.app.domain.models.User
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val localDataSource: UserLocalDataSource,
    private val remoteDataSource: UserRemoteDataSource,
) {
    suspend fun getUser(): Result<User> {
        val localUser = localDataSource.userFlow.firstOrNull()
        return localUser?.toUser()?.toResult() ?: fetchUser()
    }

    private suspend fun fetchUser(): Result<User> = remoteDataSource.fetchUser().toResult().apply {
        if (this is Result.Success) {
            val user = this.data
            user.toUserEntity()?.let { localDataSource.saveUser(it) }
        }
    }
}
