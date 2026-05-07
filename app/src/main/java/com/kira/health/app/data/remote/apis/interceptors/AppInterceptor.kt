package com.kira.health.app.data.remote.apis.interceptors

import com.kira.health.app.data.local.datasource.AuthLocalDataSource
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppInterceptor @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource
) : Interceptor {

    companion object {
        private const val HEADER_CONTENT_TYPE = "Content-Type"
        private const val HEADER_ACCEPT = "Accept"
        private const val HEADER_AUTHORIZATION = "Authorization"
        private const val VALUE_APPLICATION_JSON = "application/json"
        private const val VALUE_BEARER = "Bearer "
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = runBlocking {
            authLocalDataSource.tokenFlow.firstOrNull()
        }

        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header(HEADER_CONTENT_TYPE, VALUE_APPLICATION_JSON)
            .header(HEADER_ACCEPT, VALUE_APPLICATION_JSON)

        token?.let {
            requestBuilder.header(HEADER_AUTHORIZATION, "$VALUE_BEARER$it")
        }

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
