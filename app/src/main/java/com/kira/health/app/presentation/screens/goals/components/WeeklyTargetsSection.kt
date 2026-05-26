package com.kira.health.app.presentation.screens.goals.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kira.health.R

@Composable
fun WeeklyTargetsSection(
    modifier: Modifier = Modifier,
    title: String,
    actionText: String,
    stepsValue: String,
    distanceValue: String
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                color = colorResource(R.color.color_1F1A1C),
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = actionText,
                color = colorResource(R.color.color_9B0044),
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            WeeklyTargetCard(
                icon = R.drawable.icon_step,
                title = "Steps",
                value = stepsValue,
                progress = 0.75f,
                progressColor = R.color.color_C2185B,
            )

            WeeklyTargetCard(
                icon = R.drawable.icon_distance,
                title = "Distance",
                value = distanceValue,
                progress = 0.764f,
                progressColor = R.color.color_9b0044,
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun WeeklyTargetsSectionPreview() {
    WeeklyTargetsSection(
        title = "Weekly Targets",
        actionText = "See All",
        stepsValue = "8,000",
        distanceValue = "5.2 km"
    )
}
