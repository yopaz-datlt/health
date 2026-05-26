package com.kira.health.app.presentation.screens.goals.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kira.health.R
import com.kira.health.app.theme.color_achievement_distance_text
import com.kira.health.app.theme.color_achievement_early_text
import com.kira.health.app.theme.color_achievement_streak_text

@Composable
fun RecentAchievementsSection(
    modifier: Modifier = Modifier,
    title: String,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = title,
            color = colorResource(R.color.color_1F1A1C),
            fontSize = 20.sp,
            lineHeight = 28.sp,
            fontWeight = FontWeight.Bold,
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AchievementCard(
                modifier = Modifier.weight(1f),
                icon = R.drawable.icon_achievement_streak,
                text = "7 DAY STREAK",
                textColor = color_achievement_streak_text,
            )
            AchievementCard(
                modifier = Modifier.weight(1f),
                icon = R.drawable.icon_achievement_distance_champ,
                text = "DISTANCE\nCHAMP",
                textColor = color_achievement_distance_text,
            )
            AchievementCard(
                modifier = Modifier.weight(1f),
                icon = R.drawable.icon_achievement_early_bird,
                text = "EARLY BIRD",
                textColor = color_achievement_early_text,
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun RecentAchievementsSectionPreview() {
    RecentAchievementsSection(
        title = "Recent Achievements"
    )
}
