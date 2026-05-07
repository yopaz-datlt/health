package com.kira.health.app.data.local.datasource

import com.kira.health.app.data.local.localstorage.LocalStorageManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthLocalDataSource @Inject constructor(
    private val localStorageManager: LocalStorageManager
) {
    val tokenFlow: Flow<String?> = localStorageManager.tokenFlow

    suspend fun saveToken(token: String) {
        localStorageManager.saveToken(token)
    }

    suspend fun clearToken() {
        localStorageManager.clearToken()
    }
}
