package com.kira.health.app.presentation.screens.daily

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kira.health.R
import com.kira.health.app.presentation.screens.daily.components.ActivityStatsCard
import com.kira.health.app.presentation.screens.daily.components.ActivityStatsHeader
import com.kira.health.app.presentation.screens.daily.components.DashboardTopBar
import com.kira.health.app.presentation.screens.daily.components.InformationCard

@Composable
fun DailyScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colorResource(R.color.color_fff8f8),
        topBar = { DashboardTopBar(modifier = Modifier.fillMaxWidth()) },
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
private fun ActivityStatSection() {
    ActivityStatsHeader(modifier = Modifier.fillMaxWidth())
    ActivityStatsCard(
        modifier = Modifier.fillMaxWidth(),
        label = "STEPS",
        period = "Last 30 days",
        value = "8,421",
        unit = "steps",
        accent = colorResource(R.color.color_9b0044),
        icon = painterResource(R.drawable.icon_steps)
    )
    ActivityStatsCard(
        modifier = Modifier.fillMaxWidth(),
        label = "DISTANCE",
        period = "Last 30 days",
        value = "42.5",
        unit = "km",
        accent = colorResource(R.color.color_964261),
        icon = painterResource(R.drawable.icon_distance)
    )
}

@Preview(showBackground = true)
@Composable
fun DailyScreenPreview() {
    DailyScreen()
}
