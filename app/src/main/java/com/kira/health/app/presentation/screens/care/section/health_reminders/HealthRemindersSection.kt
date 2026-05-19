package com.kira.health.app.presentation.screens.care.section.health_reminders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kira.health.R

@Composable
fun HealthRemindersSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Health Reminders",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.color_1F1A1C)
        )

        Surface(
            shape = RoundedCornerShape(32.dp),
            color = colorResource(R.color.color_FBF1F3)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                ReminderItem(title = "Step Goal Reminder", reminderIcon = R.drawable.icon_step)
                ReminderItem(title = "Daily Walk Alert", reminderIcon = R.drawable.icon_walk)
                ReminderItem(title = "Distance Target", reminderIcon = R.drawable.icon_distance)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HealthRemindersSectionPreview() {
    HealthRemindersSection()
}
