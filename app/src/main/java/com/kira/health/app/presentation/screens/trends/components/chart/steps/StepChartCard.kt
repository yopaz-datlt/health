package com.kira.health.app.presentation.screens.trends.components.chart.steps

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kira.health.R
import com.kira.health.app.data.remote.apis.models.responses.StepsModel

@Composable
fun StepChartCard(
    modifier: Modifier = Modifier,
    stepsModel: StepsModel
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.space_16)),
        shape = RoundedCornerShape(dimensionResource(R.dimen.space_32)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = BorderStroke(
            width = dimensionResource(R.dimen.space_1),
            color = Color(0x80FFE4E6)
        )
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.space_24)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_12))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_4))) {
                    Text(
                        text = stepsModel.title,
                        color = Color(0xFF594045),
                        lineHeight = dimensionResource(R.dimen.text_20).value.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = stepsModel.totalSteps,
                        color = colorResource(R.color.color_C2185B),
                        fontSize = dimensionResource(R.dimen.text_30).value.sp,
                        lineHeight = dimensionResource(R.dimen.text_36).value.sp,
                        fontWeight = FontWeight.Black
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.icon_up),
                            null
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.space_4)))
                        Text(
                            text = stepsModel.trendText,
                            color = colorResource(R.color.color_16A34A),
                            fontSize = dimensionResource(R.dimen.text_12).value.sp,
                            lineHeight = dimensionResource(R.dimen.text_16).value.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Image(
                    painter = painterResource(R.drawable.icon_jogging),
                    null
                )
            }

            StepsChart(stepsModel.labels, stepsModel.steps, stepsModel.maxSteps)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StepChartCardPreview() {
    StepChartCard(
        modifier = Modifier.padding(horizontal = 16.dp),
        StepsModel(
        "Daily Average Steps",
        "8,432",
            "15% more than last week",
            listOf("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"),
            listOf(600, 400, 300, 400, 900, 800, 1000),
            1000
        )
    )
}
