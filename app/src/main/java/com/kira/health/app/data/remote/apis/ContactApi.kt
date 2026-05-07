package com.kira.health.app.data.remote.apis

import com.kira.health.app.data.remote.apis.models.responses.BaseResponse
import com.kira.health.app.domain.models.Contact
import retrofit2.Response
import retrofit2.http.GET

interface ContactApi {

    @GET("contact/list")
    suspend fun fetchContacts(): Response<BaseResponse<List<Contact>>>
}

