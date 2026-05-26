package com.kira.health.app.presentation.screens.goals.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kira.health.R
import com.kira.health.app.theme.color_card_border

@Composable
fun WeeklyTargetCard(
    modifier: Modifier = Modifier,
    icon: Int,
    title: String,
    value: String,
    progress: Float,
    progressColor: Int,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.white)),
        border = BorderStroke(1.dp, color_card_border),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = title,
                        color = colorResource(R.color.color_1F1A1C),
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = value,
                        color = colorResource(R.color.color_9B0044),
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                }

                HealthProgressBar(
                    progress = progress,
                    trackColor = R.color.color_FFE4E6,
                    fillColor = progressColor,
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun WeeklyTargetCardPreview() {
    WeeklyTargetCard(
        icon = R.drawable.icon_step,
        title = "Steps",
        value = "8,000",
        progress = 0.75f,
        progressColor = R.color.color_9B0044,
    )
}
