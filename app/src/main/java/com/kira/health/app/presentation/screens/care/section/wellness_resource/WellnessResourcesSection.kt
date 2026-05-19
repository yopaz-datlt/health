package com.kira.health.app.presentation.screens.care.section.wellness_resource

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kira.health.R

@Composable
fun WellnessResourcesSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Wellness Resources",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.color_1F1A1C)
        )

        val cards = listOf(
            WellnessCard("Meditation", "Relax and reset"),
            WellnessCard("Healthy Eating", "Fuel your day"),
            WellnessCard("Sleep Tips", "Rest better")
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(end = 24.dp)
        ) {
            items(cards) { card ->
                WellnessResourceItem(card = card)
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun WellnessResourcesSectionPreview() {
    WellnessResourcesSection()
}
