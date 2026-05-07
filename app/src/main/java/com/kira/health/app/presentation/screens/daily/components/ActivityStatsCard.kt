package com.kira.health.app.presentation.screens.daily.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kira.health.R

@Composable
fun ActivityStatsCard(
    modifier: Modifier = Modifier,
    label: String,
    period: String,
    value: String,
    unit: String,
    accent: Color,
    icon: Painter,
) {
    Surface(
        modifier = modifier,
        color = colorResource(R.color.color_fbf1f3),
        shape = RoundedCornerShape(dimensionResource(R.dimen.space_32))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.space_24)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = label,
                    color = accent,
                    fontSize = dimensionResource(R.dimen.text_11).value.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = period,
                    color = colorResource(R.color.color_664347),
                    fontSize = dimensionResource(R.dimen.text_12).value.sp
                )
                Row(
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.space_8)),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_4)),
                ) {
                    Text(
                        text = value,
                        fontSize = dimensionResource(R.dimen.text_36).value.sp,
                        color = colorResource(R.color.color_1f1a1c),
                        fontWeight = FontWeight.Black
                    )
                    Text(
                        modifier = Modifier.padding(bottom = dimensionResource(R.dimen.space_4)),
                        text = unit,
                        color = colorResource(R.color.color_664347),
                    )
                }
            }
            Image(painter = icon, null)
        }
    }
}

@Preview
@Composable
private fun ActivityStatsCardView() {
    ActivityStatsCard(
        modifier = Modifier.fillMaxWidth(),
        label = "STEPS",
        period = "Last 30 days",
        value = "8,421",
        unit = "steps",
        accent = colorResource(R.color.color_9b0044),
        icon = painterResource(R.drawable.icon_steps)
    )
}
