package com.kira.health.app.data.repositories

import com.kira.health.app.data.remote.datasource.ContactRemoteDataSource
import com.kira.health.app.data.result.toResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactRepository @Inject constructor(
    private val remoteDataSource: ContactRemoteDataSource
) {

    suspend fun fetchContacts() = remoteDataSource.fetchContacts().toResult()
}
