package com.kira.health.app.data.local.localstorage

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalStorageModule {

    @Provides
    @Singleton
    fun provideLocalStorageManager(@ApplicationContext context: Context): LocalStorageManager {
        return LocalStorageManager(context)
    }
}
