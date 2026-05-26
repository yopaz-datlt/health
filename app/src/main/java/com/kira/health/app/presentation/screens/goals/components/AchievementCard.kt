package com.kira.health.app.presentation.screens.goals.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kira.health.R

@Composable
fun AchievementCard(
    modifier: Modifier = Modifier,
    icon : Int,
    text: String,
    textColor: Color,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(48.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, colorResource(R.color.white)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = text,
                color = textColor,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.5).sp,
                textAlign = TextAlign.Center,
                minLines = 2,
            )

            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}


@Composable
@Preview
private fun AchievementCardPreview() {
    AchievementCard(
        icon = R.drawable.icon_achievement_streak,
        text = "7 DAY STREAK",
        textColor = colorResource(R.color.color_92400E)
    )
}
