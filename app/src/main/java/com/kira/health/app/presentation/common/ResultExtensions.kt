package com.kira.health.app.presentation.common

import com.kira.health.app.data.result.Result

fun <T> Result<T>.toState(): State<T> =
    when (this) {
        is Result.Success -> State(
            isLoading = false,
            data = data,
            errorMessage = null
        )

        is Result.Error -> State(
            isLoading = false,
            data = null,
            errorMessage = message
        )
    }
