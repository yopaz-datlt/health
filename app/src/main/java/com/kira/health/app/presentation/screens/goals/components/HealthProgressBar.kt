package com.kira.health.app.presentation.screens.goals.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kira.health.R

@Composable
fun HealthProgressBar(
    modifier: Modifier = Modifier,
    progress: Float,
    trackColor: Int,
    fillColor: Int,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(8.dp)
            .clip(RoundedCornerShape(9999.dp))
            .background(colorResource(trackColor))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(fraction = progress.coerceIn(0f, 1f))
                .height(8.dp)
                .clip(RoundedCornerShape(9999.dp))
                .background(colorResource(fillColor))
        )
    }
}


@Composable
@Preview
private fun HealthProgressBarPreview() {
    HealthProgressBar(
        progress = 0.75f,
        trackColor = R.color.color_9B0044,
        fillColor = R.color.color_E1BEC4,
        modifier = Modifier.fillMaxWidth()
    )
}
