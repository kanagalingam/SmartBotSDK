package com.learn.smartbot.internal.ui.atom

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.learn.smartbot.internal.util.DeliveryStatus

@Composable
fun AtomDeliveryStatusIcon(
    imageUrl: String? = null,
    status: DeliveryStatus = DeliveryStatus.Delivered(),
    contentDescription: String? = null,
    size: Dp = 48.dp,
    alignment: Alignment = Alignment.Center,
) {
    val context = LocalContext.current
    val modifier = Modifier.size(size)

    val model = if (!imageUrl.isNullOrBlank()) {
        imageUrl
    } else {
        val iconName = when (status) {
            is DeliveryStatus.Delivered -> "ic_delivered"
            is DeliveryStatus.Error -> "ic_error"
            is DeliveryStatus.NotDelivered -> "ic_not_delivered"
            is DeliveryStatus.Seen -> "ic_seen"
        }
        context.resources.getIdentifier(iconName, "drawable", context.packageName)
    }

    AsyncImage(
        modifier = modifier,
        model = model,
        contentDescription = contentDescription,
        alignment = alignment,
    )
}