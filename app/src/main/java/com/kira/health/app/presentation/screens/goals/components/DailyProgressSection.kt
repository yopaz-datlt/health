package com.kira.health.app.presentation.screens.goals.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
fun DailyProgressSection(
    modifier: Modifier = Modifier,
    title: String,
    stepsPercent: Int,
    stepsLabel: String,
    stepsValue: String,
    distancePercent: Int,
    distanceLabel: String,
    distanceValue: String,
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            color = colorResource(R.color.color_1F1A1C),
            fontSize = 24.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(48.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(R.color.white)),
            border = BorderStroke(1.dp, colorResource(R.color.color_E1BEC4)),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                DailyProgressItem(
                    percent = stepsPercent,
                    percentColor = R.color.color_9b0044,
                    label = stepsLabel,
                    value = stepsValue,
                )

                DailyProgressItem(
                    percent = distancePercent,
                    percentColor = R.color.color_C2185B,
                    label = distanceLabel,
                    value = distanceValue,
                )
            }
        }
    }
}


@Composable
@Preview
private fun DailyProgressSectionPreview() {
    DailyProgressSection(
        title = "Daily Progress",
        stepsPercent = 75,
        stepsLabel = "STEPS",
        stepsValue = "7,500 / 10,000",
        distancePercent = 50,
        distanceLabel = "DISTANCE",
        distanceValue = "5.0 / 10.0 km",
    )
}
