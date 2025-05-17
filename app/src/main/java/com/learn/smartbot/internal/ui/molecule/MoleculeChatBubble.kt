package com.learn.smartbot.internal.ui.molecule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.learn.smartbot.internal.ui.atom.AtomAvatarImage
import com.learn.smartbot.internal.ui.atom.AtomDeliveryStatusIcon
import com.learn.smartbot.internal.ui.atom.AtomMessageBubbleShape
import com.learn.smartbot.internal.ui.atom.AtomTimestampText
import com.learn.smartbot.internal.ui.atom.AtomUsername
import com.learn.smartbot.internal.util.AppConstants.EMPTY_STRING
import com.learn.smartbot.internal.util.DeliveryStatus

@Composable
fun MoleculeChatBubble(
    isSender: Boolean = false,
    userName: String = EMPTY_STRING,
    timeStamp: String = EMPTY_STRING,
    message: String = EMPTY_STRING,
    deliveryStatus: DeliveryStatus,
    userProfileIconUrl: String? = null
) {
    Box {
        AtomMessageBubbleShape(
            isSender = isSender
        )
        Column {
            Row {
                AtomAvatarImage(imageUrl = userProfileIconUrl)
                AtomUsername(userName)
                AtomTimestampText(timeStamp)
            }
            Text(text = message)
        }
        AtomDeliveryStatusIcon(status = deliveryStatus)

    }

}
