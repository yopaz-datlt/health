package com.kira.health.app.presentation.screens.trends.components.chart.steps

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kira.health.R

private const val STEPS_CHAT_HEIGHT = 128f
private const val SPACING = 8f

@Composable
fun StepsChart(
    labels: List<String>,
    steps: List<Int>,
    maxSteps: Int
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0x99C2185B).copy(0.1f),
                            Color.White
                        )
                    )
                )
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.space_4))
                    .height(STEPS_CHAT_HEIGHT.dp)
            ) {
                val width = (size.width - (steps.size - 1) * SPACING) / steps.size
                steps.forEachIndexed { index, step ->
                    val left = index * (width + SPACING)
                    val path = Path().apply {
                        addRoundRect(
                            RoundRect(
                                left = left,
                                top = size.height - size.height * (step.toFloat() / maxSteps),
                                bottom = size.height,
                                right = left + width,
                                topLeftCornerRadius = CornerRadius(width / 2),
                                topRightCornerRadius = CornerRadius(width / 2),
                            )
                        )
                    }
                    val percentage = step.toFloat() / maxSteps
                    val pathColor = when {
                        percentage == 1f -> Color(0xFFC2185B)
                        percentage > 0.7f -> Color(0x99C2185B)
                        percentage > 0.5f -> Color(0x80C2185B)
                        percentage > 0.3f -> Color(0x4DC2185B)
                        else -> Color(0x33C2185B)
                    }
                    drawPath(path, pathColor)
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(R.dimen.space_12)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            labels.forEach { label ->
                Text(
                    text = label,
                    fontSize = dimensionResource(R.dimen.text_12).value.sp,
                    color = colorResource(R.color.color_8D6F75),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StepsChartPreview() {
    StepsChart(
        listOf("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"),
        listOf(600, 400, 300, 400, 900, 800, 1000),
        1000
    )
}
