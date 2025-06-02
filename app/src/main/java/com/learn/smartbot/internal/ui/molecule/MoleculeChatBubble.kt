package com.learn.smartbot.internal.ui.molecule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.learn.smartbot.internal.ui.atom.AtomAvatarImage
import com.learn.smartbot.internal.ui.atom.AtomDeliveryStatusIcon
import com.learn.smartbot.internal.ui.atom.AtomTimestampText
import com.learn.smartbot.internal.ui.atom.AtomUsername
import com.learn.smartbot.internal.util.DeliveryStatus


@Composable
fun MoleculeChatBubble(
    isUserSentMessage: Boolean,
    userProfileIconUrl: String? = null,
    userName: String,
    timeStamp: String,
    message: String,
    deliveryStatus: DeliveryStatus
) {
    Card{
         Box(
             modifier = Modifier.background(
                 color = if (isUserSentMessage) {
                     // User sent message bubble color
                     Color(0xFFECECEC)
                 } else {
                     // Bot sent message bubble color
                     Color(0xFFC1E3FA)
                 }
             )
         ) {
             Column(
                 modifier = Modifier
                     .padding(8.dp),
                 horizontalAlignment = if (isUserSentMessage) {
                     Alignment.Start
                 } else {
                     Alignment.End
                 }
             ) {
                 // 1st Row - Avatar + Username + Timestamp
                 Row(
                     verticalAlignment = Alignment.CenterVertically,
                     modifier = Modifier.fillMaxWidth()
                 ) {
                     AtomAvatarImage(
                         imageUrl = userProfileIconUrl,
                         size = 24.dp
                     )
                     Spacer(modifier = Modifier.width(4.dp))
                     AtomUsername(userName)

                     Spacer(modifier = Modifier.weight(1f))

                     AtomTimestampText(timeStamp)
                 }

                 // 2nd Row - Message Text
                 Text(
                     text = message,
                     modifier = Modifier.padding(top = 4.dp)
                 )

                 // 3rd Row - Delivery status at end
                 Row(
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(top = 4.dp),
                     horizontalArrangement = Arrangement.End
                 ) {
                     AtomDeliveryStatusIcon(status = deliveryStatus)
                 }
             }
         }
     }
}

