package com.kira.health.app.presentation.screens.care.section.health_reminders

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kira.health.R

@Composable
fun ReminderItem(
    modifier: Modifier = Modifier,
    title: String,
    reminderIcon : Int
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(6.dp),
        color = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp,
                    colorResource(R.color.color_FFFFFF),
                    RoundedCornerShape(6.dp)
                )
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Image(
                    painter = painterResource(reminderIcon),
                    contentDescription = null
                )

                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.color_1F1A1C)
                )
            }

            Switch(
                checked = true,
                onCheckedChange = { },
                colors = androidx.compose.material3.SwitchDefaults.colors(
                    checkedThumbColor = colorResource(R.color.color_FFFFFF),
                    uncheckedThumbColor = colorResource(R.color.color_FFFFFF),
                    checkedTrackColor = colorResource(R.color.color_C2185B),
                    uncheckedTrackColor = colorResource(R.color.color_FECDD3)
                )
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ReminderItemPreview() {
    ReminderItem(
        title = "Step Goal Reminder",
        reminderIcon = R.drawable.icon_step
    )
}
