package com.kira.health.app.presentation.screens.goals

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kira.health.R
import com.kira.health.app.presentation.screens.goals.components.DailyProgressSection
import com.kira.health.app.presentation.screens.goals.components.RecentAchievementsSection
import com.kira.health.app.presentation.screens.goals.components.TopHeader
import com.kira.health.app.presentation.screens.goals.components.WeeklyTargetsSection

@Composable
fun GoalsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 24.dp)
            .background(colorResource(R.color.color_FBF1F3)),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        TopHeader(title = stringResource(R.string.app_name))

        DailyProgressSection(
            modifier = Modifier.padding(horizontal = 24.dp),
            title = "Daily Progress",
            stepsPercent = 74,
            stepsLabel = "STEPS",
            stepsValue = "8,421 / 10k",
            distancePercent = 76,
            distanceLabel = "DISTANCE",
            distanceValue = "7.6 / 10 km"
        )

        WeeklyTargetsSection(
            modifier = Modifier.padding(horizontal = 24.dp),
            title = "Weekly Targets",
            actionText = "View History",
            stepsValue = "52,400 / 70k",
            distanceValue = "38.2 / 50 km",
        )

        RecentAchievementsSection(
            modifier = Modifier.padding(horizontal = 24.dp),
            title = "Recent Achievements",
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HealthMainContentPreview() {
    MaterialTheme {
        GoalsScreen()
    }
}
