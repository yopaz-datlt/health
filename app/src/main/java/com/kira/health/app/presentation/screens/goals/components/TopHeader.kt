package com.kira.health.app.presentation.screens.goals.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun TopHeader(
    modifier: Modifier = Modifier,
    title: String,
) {
    Box(modifier = modifier
        .fillMaxWidth()
        .background(colorResource(R.color.white))
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 12.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(R.drawable.icon_logo),
                contentDescription = null,
            )
            Text(
                modifier = modifier.padding(start = 12.dp),
                text = title,
                color = colorResource(R.color.color_005E53),
                fontSize = 24.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Black,
                letterSpacing = (-0.6).sp,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun TopHeaderPreview() {
    TopHeader(title = "Health")
}
