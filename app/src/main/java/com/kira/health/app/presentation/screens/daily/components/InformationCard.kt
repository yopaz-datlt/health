package com.kira.health.app.presentation.screens.daily.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kira.health.R

@Composable
fun InformationCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimensionResource(R.dimen.space_32)))
            .background(
                Brush.linearGradient(
                    listOf(
                        colorResource(R.color.color_9b0044), colorResource(R.color.color_964261)
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

@Preview
@Composable
private fun InformationCardPreview() {
    InformationCard()
}
