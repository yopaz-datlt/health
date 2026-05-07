package com.kira.health.app.domain.models

import com.kira.health.app.data.local.db.entity.UserEntity
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val id: Int? = null,
    val name: String? = null,
    val email: String? = null
) {
    fun toUserEntity() = id?.let {
        UserEntity(
            id = it,
            name = name,
            email = email
        )
    }
}
