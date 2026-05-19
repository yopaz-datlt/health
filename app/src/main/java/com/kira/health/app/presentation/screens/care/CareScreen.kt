package com.kira.health.app.presentation.screens.care

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kira.health.R
import com.kira.health.app.presentation.screens.care.section.health_reminders.HealthRemindersSection
import com.kira.health.app.presentation.screens.care.section.wellness_resource.WellnessResourcesSection

@Composable
fun CareScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.color_FFF8F8))
    ) {
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            CareTopAppBar()
            WellnessResourcesSection()
            HealthRemindersSection()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CareScreenPreview() {
    CareScreen()
}
