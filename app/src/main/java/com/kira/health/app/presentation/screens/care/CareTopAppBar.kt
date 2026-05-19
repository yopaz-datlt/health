package com.kira.health.app.presentation.screens.care

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
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
fun CareTopAppBar(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = colorResource(R.color.color_F9F9F9).copy(alpha = 0.8f),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.icon_health_logo),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Health",
                fontSize = 24.sp,
                fontWeight = FontWeight.Black,
                color = colorResource(R.color.color_005E53)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CareTopAppBarPreview() {
    CareTopAppBar()
}
