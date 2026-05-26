package com.kira.health.app.presentation.screens.goals.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kira.health.R

@Composable
fun DailyProgressItem(
    percent: Int,
    percentColor: Int,
    label: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(128.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        RadialPercentBadge(
            percent = percent,
            color = percentColor
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = label,
                color = colorResource(R.color.color_1F1A1C),
                fontSize = 10.sp,
                lineHeight = 15.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp,
            )

            Text(
                text = value,
                color = colorResource(R.color.color_1F1A1C),
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun DailProgressItemPreview() {
    DailyProgressItem(
        percent = 75,
        percentColor = R.color.color_C2185B,
        label = "DISTANCE",
        value = "3.5 KM",
    )
}
