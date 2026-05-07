package com.kira.health.app.presentation.screens.daily

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
fun DailyScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colorResource(R.color.color_fff8f8),
        topBar = { DashboardTopBar() },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(
                    horizontal = dimensionResource(R.dimen.space_24),
                    vertical = dimensionResource(R.dimen.space_16)
                )
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_16))
        ) {
            InformationCard()
            ActivityStatSection()
        }
    }
}

@Composable
private fun DashboardTopBar() {
    Surface(
        color = colorResource(R.color.color_f9f9f9).copy(alpha = 0.8f),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimensionResource(R.dimen.space_24),
                    vertical = dimensionResource(R.dimen.space_14)
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.icon_health_logo),
                null
            )
            Text(
                modifier = Modifier.padding(start = dimensionResource(R.dimen.space_12)),
                text = "Health",
                fontWeight = FontWeight.Black,
                fontSize = dimensionResource(R.dimen.text_24).value.sp,
                color = colorResource(R.color.color_005e53)
            )
        }
    }
}

@Composable
private fun InformationCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimensionResource(R.dimen.space_32)))
            .background(
                Brush.linearGradient(
                    listOf(
                        colorResource(R.color.color_9b0044),
                        colorResource(R.color.color_964261)
                    )
                )
            )
            .padding(dimensionResource(R.dimen.space_32))
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_8))) {
            Text(
                text = "MORNING OVERVIEW",
                color = colorResource(R.color.white),
                fontSize = dimensionResource(R.dimen.text_12).value.sp
            )
            Text(
                text = "You're doing great, Alex.",
                fontSize = dimensionResource(R.dimen.text_30).value.sp,
                color = colorResource(R.color.white),
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(top = dimensionResource(R.dimen.space_8)),
                text = "Your activity levels are 12% higher than last Tuesday. Keep up the momentum.",
                color = colorResource(R.color.white).copy(alpha = 0.9f),
            )
        }
    }
}

@Composable
private fun ActivityStatSection() {
    SectionHeader()
    ActivityStatsCard(
        label = "STEPS",
        period = "Last 30 days",
        value = "8,421",
        unit = "steps",
        accent = colorResource(R.color.color_9b0044),
        icon = painterResource(R.drawable.icon_steps)
    )
    ActivityStatsCard(
        label = "DISTANCE",
        period = "Last 30 days",
        value = "42.5",
        unit = "km",
        accent = colorResource(R.color.color_964261),
        icon = painterResource(R.drawable.icon_distance)
    )
}

@Composable
private fun SectionHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.space_8)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Activity Stats",
            fontSize = dimensionResource(R.dimen.text_18).value.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.color_1f1a1c)
        )
        Text(
            text = "LATEST UPDATE: 2M AGO",
            fontSize = dimensionResource(R.dimen.text_10).value.sp,
            color = colorResource(R.color.color_664347)
        )
    }
}

@Composable
private fun ActivityStatsCard(
    label: String,
    period: String,
    value: String,
    unit: String,
    accent: Color,
    icon: Painter,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
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

@Preview(showBackground = true)
@Composable
fun DailyScreenPreview() {
    DailyScreen()
}
