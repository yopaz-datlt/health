package com.kira.health.app.presentation.screens.daily.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kira.health.R

@Composable
fun DashboardTopBar(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = colorResource(R.color.color_f9f9f9).copy(alpha = 0.8f),
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

@Preview
@Composable
private fun DashboardTopBarPreview() {
    DashboardTopBar(modifier = Modifier.fillMaxWidth())
}
