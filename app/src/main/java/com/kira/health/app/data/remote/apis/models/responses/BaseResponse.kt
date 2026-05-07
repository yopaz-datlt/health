package com.kira.health.app.data.remote.apis.models.responses

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
open class BaseResponse<T>(
    var data: T?
)
