package com.kira.health.app.presentation.screens.goals.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kira.health.R

@Composable
fun RadialPercentBadge(
    modifier: Modifier = Modifier,
    percent: Int,
    color: Int,
) {
    Box(
        modifier = modifier.size(128.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.background_daily_progress),
            contentDescription = null
        )
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = percent.toString(),
                color = colorResource(color),
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Black,
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                modifier = Modifier.padding(bottom = 3.dp),
                text = "%",
                color = colorResource(color),
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.Black,
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun RadialPercentBadgePreview() {
    RadialPercentBadge(
        percent = 75,
        color = R.color.color_9b0044,
    )
}
