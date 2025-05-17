package com.learn.smartbot.internal.ui.atom

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AtomTimestampText(
    timeStampToDisplay: String
) {
    Text(
        text = timeStampToDisplay
    )
}