package com.kira.health.app.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kira.health.app.domain.models.User

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int,
    val name: String?,
    val email: String?
) {
    fun toUser() = User(
        id = id,
        name = name,
        email = email
    )
}
