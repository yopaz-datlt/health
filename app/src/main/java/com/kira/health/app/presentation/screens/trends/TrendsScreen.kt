package com.kira.health.app.presentation.screens.trends

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kira.health.app.presentation.screens.trends.components.page.DayPage
import com.kira.health.app.presentation.screens.trends.components.page.MonthPage
import com.kira.health.app.presentation.screens.trends.components.page.WeekPage
import kotlinx.coroutines.launch

@Composable
fun TrendsScreen() {
    val tabs = TrendsTab.entries.map { it.title }
    val pageState = rememberPagerState {
        tabs.size
    }

    val coroutineScope = rememberCoroutineScope()

    Column(Modifier.fillMaxWidth().fillMaxHeight()) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .align(Alignment.End)
                .padding(4.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFFE8E0E3)),
        ) {
            tabs.forEachIndexed { index, title ->
                val isSelected = pageState.currentPage == index
                val backgroundColor by animateColorAsState(
                    targetValue = if (isSelected) Color(0xFFC2185B) else Color.Transparent,
                    label = ""
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(backgroundColor)
                        .clickable {
                            coroutineScope.launch {
                                pageState.animateScrollToPage(index)
                            }
                        }
                        .padding(horizontal = 16.dp, vertical = 5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title,
                        color = if (isSelected) Color.White else Color(0xFF6D4C57),
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            state = pageState
        ) { page ->
            when (page) {
                TrendsTab.DAY.ordinal -> DayPage()
                TrendsTab.WEEK.ordinal -> WeekPage()
                TrendsTab.MONTH.ordinal -> MonthPage()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun TrendsScreenPreview() {
    TrendsScreen()
}
