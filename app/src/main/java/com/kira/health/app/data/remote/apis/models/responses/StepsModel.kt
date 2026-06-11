package com.kira.health.app.data.remote.apis.models.responses

data class StepsModel(
    val title: String,
    val totalSteps: String,
    val trendText: String,
    val labels: List<String>,
    val steps: List<Int>,
    val maxSteps: Int
)
