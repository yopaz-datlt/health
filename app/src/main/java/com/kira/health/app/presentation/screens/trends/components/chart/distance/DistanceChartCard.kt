package com.kira.health.app.presentation.screens.trends.components.chart.distance

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
import com.kira.health.app.data.remote.apis.models.responses.DistanceModel

@Composable
fun DistanceChartCard(modifier: Modifier = Modifier, distanceModel: DistanceModel) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.space_16)),
        shape = RoundedCornerShape(dimensionResource(R.dimen.space_32)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(R.dimen.space_2)),
        border = BorderStroke(
            width = dimensionResource(R.dimen.space_1),
            color = Color(0x80FFE4E6)
        )
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_4))) {
                    Text(
                        text = distanceModel.title,
                        color = colorResource(R.color.color_594045),
                        lineHeight = dimensionResource(R.dimen.space_20).value.sp,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = dimensionResource(R.dimen.space_0).value.sp
                    )
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = distanceModel.distance,
                            color = colorResource(R.color.color_964261),
                            fontSize = dimensionResource(R.dimen.space_30).value.sp,
                            lineHeight = dimensionResource(R.dimen.space_36).value.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 0.sp
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.space_4)))
                        Text(
                            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.space_4)),
                            text = distanceModel.unit,
                            color = colorResource(R.color.color_964261),
                            lineHeight = dimensionResource(R.dimen.space_20).value.sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = 0.sp
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(R.drawable.icon_up),
                            null
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.space_4)))
                        Text(
                            text = distanceModel.trendText,
                            color = colorResource(R.color.color_16A34A),
                            fontSize = dimensionResource(R.dimen.space_12).value.sp,
                            lineHeight = dimensionResource(R.dimen.space_16).value.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Image(
                    painterResource(R.drawable.icon_daily_average_distance),
                    null
                )
            }
            DistanceAreaChart(
                distanceModel.distances,
                distanceModel.distanceMax,
                distanceModel.timeLabels
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DistanceChartCardPreview() {
    DistanceChartCard(
        modifier = Modifier.padding(dimensionResource(R.dimen.space_16)),
        DistanceModel(
            title = "Daily Average Distance",
            distance = "4.6",
            unit = "km",
            trendText = "+2.1 km vs last week",
            listOf(4f, 6f, 8f, 4f, 5f, 4f, 3f, 2f, 4f, 6f),
            10f,
            listOf("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")
        )
    )
}
