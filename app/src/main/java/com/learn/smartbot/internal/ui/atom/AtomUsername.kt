package com.learn.smartbot.internal.ui.atom

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight


@Composable
fun AtomUsername(
    userName : String
) {
    Text(
        text = userName,
        fontWeight = FontWeight.Bold
    )
}