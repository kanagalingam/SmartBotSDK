package com.learn.smartbot.internal.ui.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AtomMessageBubbleShape(
    isUserSentMessage: Boolean
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(
                color = if (isUserSentMessage) Color(0xFFDCF8C6) else Color.Green,
            )
            .padding(16.dp)
    )
}


