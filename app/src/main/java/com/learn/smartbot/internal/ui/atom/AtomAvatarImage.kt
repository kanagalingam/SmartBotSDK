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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.learn.smartbot.R
import com.learn.smartbot.internal.util.AppConstants.EMPTY_STRING

@Preview
@Composable
fun AtomAvatarImage(
    modifier: Modifier = Modifier,
    imageUrl: String? = EMPTY_STRING,
    contentDescription: String? = null,
    size: Dp = 30.dp,
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
        .clip(CircleShape)
        .then(if (showBorder) Modifier.border(borderWidth, borderColor, CircleShape) else Modifier)

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .build(),
        contentDescription = contentDescription,
        contentScale = contentScale,
        alignment = alignment,
        modifier = finalModifier,
        error = painterResource(id = R.drawable.chat_user),
        placeholder = painterResource(id = R.drawable.chat_user)
    )
}