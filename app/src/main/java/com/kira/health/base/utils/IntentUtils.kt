package com.kira.health.base.utils

import android.content.Context
import android.content.Intent
import androidx.core.app.ShareCompat
import androidx.core.net.toUri
import com.kira.health.R

object IntentUtils {

    private const val PLAIN_TEXT_TYPE = "text/plain"

    fun shareUrl(
        context: Context,
        url: String,
        title: String = context.getString(R.string.share_using)
    ) {
        ShareCompat.IntentBuilder(context)
            .setType(PLAIN_TEXT_TYPE)
            .setChooserTitle(title)
            .setText(url)
            .startChooser()
    }

    fun openUrl(context: Context, url: String) {
        try {
            context.startActivity(
                Intent(Intent.ACTION_VIEW, url.toUri()).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
