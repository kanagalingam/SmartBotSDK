package com.learn.smartbot.internal.ui.atom

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.learn.smartbot.R

@Composable
fun AtomAvatarImage(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    contentDescription: String? = null,
    size: Dp = 48.dp,
    shape: Shape = CircleShape,
    placeholder: Painter = painterResource(id = R.drawable.chat_user),
    error: Painter = painterResource(id = R.drawable.chat_user),
    contentScale: ContentScale = ContentScale.Crop,
    alignment: Alignment = Alignment.Center,
    showBorder: Boolean = false,
    borderColor: Color = Color.Gray,
    borderWidth: Dp = 1.dp,
    onClick: (() -> Unit)? = null
) {
    val clickableModifier = if (onClick != null) {
        Modifier.clickable { onClick() }
    } else Modifier

    val finalModifier = modifier
        .then(clickableModifier)
        .size(size)
        .clip(shape)
        .then(if (showBorder) Modifier.border(borderWidth, borderColor, shape) else Modifier)

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl ?: R.drawable.chat_user)
            .crossfade(true)
            .build(),
        contentDescription = contentDescription,
        placeholder = placeholder,
        error = error,
        contentScale = contentScale,
        alignment = alignment,
        modifier = finalModifier
    )
}