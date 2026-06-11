package com.kira.health.app.data.remote.apis.models.responses

data class DistanceModel(
    val title: String,
    val distance: String,
    val unit: String,
    val trendText: String,
    val distances: List<Float>,
    val distanceMax: Float,
    val timeLabels: List<String>
)
