package com.kira.health.app.data.local.datasource

import com.kira.health.app.data.local.db.dao.UserDao
import com.kira.health.app.data.local.db.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(
    private val userDao: UserDao
) {
    val userFlow: Flow<UserEntity?> = userDao.fetchUser()

    suspend fun saveUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun deleteUser() {
        userDao.deleteUser()
    }
}
