package com.kira.health.app.presentation.common

data class State<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val errorMessage: String? = null
)
