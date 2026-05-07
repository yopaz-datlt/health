package com.kira.health.app.presentation.screens.daily.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kira.health.R

@Composable
fun ActivityStatsHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
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

@Preview()
@Composable
private fun ActivityStatsHeaderPreview() {
    ActivityStatsHeader()
}
