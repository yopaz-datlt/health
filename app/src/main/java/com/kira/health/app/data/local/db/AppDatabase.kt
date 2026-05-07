package com.kira.health.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kira.health.app.data.local.db.dao.UserDao
import com.kira.health.app.data.local.db.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
