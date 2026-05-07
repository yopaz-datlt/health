package com.kira.health.base.components

import android.graphics.Color
import android.widget.ProgressBar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.github.ybq.android.spinkit.style.Circle

@Composable
fun Loading(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AndroidView(
            factory = {
                ProgressBar(context).apply {
                    isIndeterminate = true
                    indeterminateDrawable = Circle().apply {
                        setColor(Color.BLACK)
                    }
                }
            }
        )
    }
}

