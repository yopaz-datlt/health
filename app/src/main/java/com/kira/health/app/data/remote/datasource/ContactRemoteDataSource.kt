package com.kira.health.app.data.remote.datasource

import com.kira.health.app.data.remote.apis.ContactApi
import com.kira.health.app.data.remote.apis.models.responses.BaseResponse
import com.kira.health.app.domain.models.Contact
import retrofit2.Response
import javax.inject.Inject

class ContactRemoteDataSource @Inject constructor(
    private val contactApi: ContactApi
) {
    suspend fun fetchContacts(): Response<BaseResponse<List<Contact>>> {
        return contactApi.fetchContacts()
    }
}
