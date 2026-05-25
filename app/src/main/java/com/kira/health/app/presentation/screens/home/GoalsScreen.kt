package com.kira.health.app.presentation.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kira.health.R
import com.kira.health.app.theme.color_achievement_distance_bg
import com.kira.health.app.theme.color_achievement_distance_border
import com.kira.health.app.theme.color_achievement_distance_text
import com.kira.health.app.theme.color_achievement_early_bg
import com.kira.health.app.theme.color_achievement_early_border
import com.kira.health.app.theme.color_achievement_early_text
import com.kira.health.app.theme.color_achievement_streak_bg
import com.kira.health.app.theme.color_achievement_streak_border
import com.kira.health.app.theme.color_achievement_streak_text
import com.kira.health.app.theme.color_card_border
import com.kira.health.app.theme.color_distance_percent
import com.kira.health.app.theme.color_distance_value
import com.kira.health.app.theme.color_icon_distance_overlay
import com.kira.health.app.theme.color_icon_steps_bg
import com.kira.health.app.theme.color_progress_fill
import com.kira.health.app.theme.color_progress_track

@Composable
fun GoalsScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(start = 24.dp, end = 24.dp, top = 96.dp, bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        DailyProgressSection(
            title = "Daily Progress",
            stepsPercent = 74,
            stepsLabel = "STEPS",
            stepsValue = "8,421 / 10k",
            distancePercent = 76,
            distanceLabel = "DISTANCE",
            distanceValue = "7.6 / 10 km"
        )

        WeeklyTargetsSection(
            title = "Weekly Targets",
            actionText = "View History",
            stepsValue = "52,400 / 70k",
            distanceValue = "38.2 / 50 km",
        )

        RecentAchievementsSection(
            title = "Recent Achievements",
        )
    }
}

@Composable
private fun DailyProgressSection(
    modifier: Modifier = Modifier,
    title: String,
    stepsPercent: Int,
    stepsLabel: String,
    stepsValue: String,
    distancePercent: Int,
    distanceLabel: String,
    distanceValue: String,
) {
    Column(
        modifier = modifier, verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = title,
            color = colorResource(R.color.color_1F1A1C),
            fontSize = 24.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Card(
            shape = RoundedCornerShape(48.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(R.color.white)),
            border = BorderStroke(1.dp, colorResource(R.color.color_E1BEC4)),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                DailyProgressItem(
                    percent = stepsPercent,
                    percentColor = color_progress_fill,
                    label = stepsLabel,
                    value = stepsValue,
                )

                DailyProgressItem(
                    percent = distancePercent,
                    percentColor = color_distance_percent,
                    label = distanceLabel,
                    value = distanceValue,
                )
            }
        }
    }
}

@Composable
private fun DailyProgressItem(
    percent: Int,
    percentColor: Color,
    label: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(128.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        RadialPercentBadge(
            percent = percent,
            color = percentColor,
            size = 128.dp,
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = label,
                color = colorResource(R.color.color_1F1A1C),
                fontSize = 10.sp,
                lineHeight = 15.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp,
            )

            Text(
                text = value,
                color = colorResource(R.color.color_1F1A1C),
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
private fun RadialPercentBadge(
    percent: Int,
    color: Color,
    size: Dp,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.background_daily_progress),
            contentDescription = null
        )
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = percent.toString(),
                color = color,
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Black,
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = "%",
                color = color,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight.Black,
                modifier = Modifier.padding(bottom = 3.dp)
            )
        }
    }
}

@Composable
private fun WeeklyTargetsSection(
    modifier: Modifier = Modifier,
    title: String,
    actionText: String,
    stepsValue: String,
    distanceValue: String
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                color = colorResource(R.color.color_1F1A1C),
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = actionText,
                color = colorResource(R.color.color_9B0044),
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            WeeklyTargetCard(
                title = "Steps",
                value = stepsValue,
                leftIconBackground = color_icon_steps_bg,
                progress = 0.75f,
                progressColor = color_progress_fill,
            )

            WeeklyTargetCard(
                title = "Distance",
                value = distanceValue,
                leftIconBackground = color_icon_distance_overlay,
                progress = 0.764f,
                progressColor = color_distance_value,
            )
        }
    }
}

@Composable
private fun WeeklyTargetCard(
    title: String,
    value: String,
    leftIconBackground: Color,
    progress: Float,
    progressColor: Color,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.white)),
        border = BorderStroke(1.dp, color_card_border),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(leftIconBackground),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title.take(1),
                    color = colorResource(R.color.color_1F1A1C),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = title,
                        color = colorResource(R.color.color_1F1A1C),
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = value,
                        color = if (title == "Steps") colorResource(R.color.color_9B0044) else color_distance_value,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = if (title == "Steps") FontWeight.SemiBold else FontWeight.SemiBold,
                    )
                }

                HealthProgressBar(
                    progress = progress,
                    trackColor = color_progress_track,
                    fillColor = progressColor,
                )
            }
        }
    }
}

@Composable
private fun HealthProgressBar(
    progress: Float,
    trackColor: Color,
    fillColor: Color,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(8.dp)
            .clip(RoundedCornerShape(9999.dp))
            .background(trackColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(fraction = progress.coerceIn(0f, 1f))
                .height(8.dp)
                .clip(RoundedCornerShape(9999.dp))
                .background(fillColor)
        )
    }
}

@Composable
private fun RecentAchievementsSection(
    title: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = title,
            color = colorResource(R.color.color_1F1A1C),
            fontSize = 20.sp,
            lineHeight = 28.sp,
            fontWeight = FontWeight.Bold,
        )

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            AchievementCard(
                modifier = Modifier.weight(1f),
                iconFill = color_achievement_streak_bg,
                iconBorder = color_achievement_streak_border,
                text = "7 DAY STREAK",
                textColor = color_achievement_streak_text,
            )
            AchievementCard(
                modifier = Modifier.weight(1f),
                iconFill = color_achievement_distance_bg,
                iconBorder = color_achievement_distance_border,
                text = "DISTANCE\nCHAMP",
                textColor = color_achievement_distance_text,
            )
            AchievementCard(
                modifier = Modifier.weight(1f),
                iconFill = color_achievement_early_bg,
                iconBorder = color_achievement_early_border,
                text = "EARLY BIRD",
                textColor = color_achievement_early_text,
            )
        }
    }
}

@Composable
private fun AchievementCard(
    iconFill: Color,
    iconBorder: Color,
    text: String,
    textColor: Color,
    modifier: Modifier = Modifier,
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
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(iconFill)
                    .border(2.dp, iconBorder, CircleShape), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text.take(1),
                    color = textColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = text,
                color = textColor,
                fontSize = 10.sp,
                lineHeight = 15.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.5).sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HealthMainContentPreview() {
    MaterialTheme {
        GoalsScreen()
    }
}
