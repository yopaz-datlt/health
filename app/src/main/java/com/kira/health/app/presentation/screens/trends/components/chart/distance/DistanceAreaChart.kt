package com.kira.health.app.presentation.screens.trends.components.chart.distance

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kira.health.R

private const val PATH_WIDTH = 5f

@Composable
fun DistanceAreaChart(
    distances: List<Float>,
    distanceMax: Float,
    timeLabels: List<String>
) {
    Column {
        Canvas(
            Modifier
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.space_148))
        ) {
            val points = distances.mapIndexed { index, value ->
                val height = ((distanceMax - value) / distanceMax) * size.height
                val width = (size.width / (distances.size - 1)) * index
                Offset(width, height)
            }

            val path = Path().apply {
                moveTo(points.first().x, points.first().y)
                for (index in 1 until points.size) {
                    val previousPoint = points[index - 1]
                    val currentPoint = points[index]
                    val centerPointX = (previousPoint.x + currentPoint.x) / 2
                    cubicTo(
                        centerPointX,
                        previousPoint.y,
                        centerPointX,
                        currentPoint.y,
                        currentPoint.x,
                        currentPoint.y
                    )
                }
            }

            val area = Path().apply {
                addPath(path)
                lineTo(points.last().x, size.height)
                lineTo(points.first().x, size.height)
                close()
            }

            drawPath(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0x4D964261), Color(0x00964261)),
                    startY = 0f,
                    endY = size.height
                ),
                path = area
            )

            drawPath(
                path,
                color = Color(0xFF964261),
                style = Stroke(width = PATH_WIDTH, cap = StrokeCap.Round)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(R.dimen.space_12)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            timeLabels.forEach { day ->
                Text(
                    text = day,
                    color = colorResource(R.color.color_8D6F75),
                    fontSize = dimensionResource(R.dimen.text_10).value.sp,
                    lineHeight = dimensionResource(R.dimen.text_15).value.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun DistanceAreaChartPreview() {
    DistanceAreaChart(
        listOf(4f, 6f, 8f, 4f, 5f, 4f, 3f, 2f, 4f, 6f),
        10f,
        listOf("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")
    )
}
