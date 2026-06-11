package com.kira.health.app.presentation.screens.trends.components.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kira.health.app.data.remote.apis.models.responses.DistanceModel
import com.kira.health.app.data.remote.apis.models.responses.StepsModel
import com.kira.health.app.presentation.screens.trends.components.chart.distance.DistanceChartCard
import com.kira.health.app.presentation.screens.trends.components.chart.steps.StepChartCard

@Composable
fun WeekPage() {
    Column {
        StepChartCard(
            modifier = Modifier,
            StepsModel(
                title = "Weekly Average Steps",
                totalSteps = "6,200",
                trendText = "+1,500 steps vs last week",
                listOf("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"),
                listOf(600, 400, 300, 400, 900, 800, 1000),
                1000
            )
        )

        DistanceChartCard(
            modifier = Modifier.padding(top = 16.dp),
            DistanceModel(
                title = "Weekly Average Distance",
                distance = "4.6",
                unit = "km",
                trendText = "+2.1 km vs last week",
                listOf(4f, 6f, 8f, 4f, 5f, 4f, 3f, 2f, 4f, 6f),
                10f,
                listOf("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")
            )
        )
    }
}
