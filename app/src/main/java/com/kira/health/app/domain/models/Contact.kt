package com.kira.health.app.domain.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Contact(
    val id: Int? = null,
    val name: String? = null,
    val phone: String? = null,
    val avatarUrl: String? = null
)
