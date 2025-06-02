package com.learn.smartbot.internal.ui.atom

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

@Composable
fun AtomTimestampText(timestamp: String) {
    val formattedTime = remember(timestamp) {
        try {
            val millis = timestamp.toLong()
            val date = java.util.Date(millis)
            val sdf = java.text.SimpleDateFormat("hh:mm a", java.util.Locale.getDefault())
            sdf.format(date)
        } catch (e: Exception) {
            ""
        }
    }

    Text(
        text = formattedTime,
        style = MaterialTheme.typography.bodySmall,
        color = Color.Gray
    )
}