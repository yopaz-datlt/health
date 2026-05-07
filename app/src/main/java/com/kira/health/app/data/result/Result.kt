package com.kira.health.app.data.result

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val code: Int, val message: String) : Result<Nothing>() {
        companion object {
            enum class Code(val value: Int) {
                DEFAULT(1000),
                NETWORK(1001),
                UNAUTHORIZED(401)
            }

            enum class Message(val value: String) {
                DEFAULT("An unexpected error occurred."),
                NETWORK("Please check your internet connection and try again."),
                UNAUTHORIZED("You are not authorized to perform this action.")
            }

            val DEFAULT = Error(Code.DEFAULT.value, Message.DEFAULT.value)
        }
    }
}
