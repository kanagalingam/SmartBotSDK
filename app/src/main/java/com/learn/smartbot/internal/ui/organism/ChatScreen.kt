package com.learn.smartbot.internal.ui.organism

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.learn.smartbot.internal.model.ChatMessage
import com.learn.smartbot.internal.ui.molecule.MoleculeChatInputBar
import com.learn.smartbot.internal.ui.molecule.MoleculeChatBubble
import com.learn.smartbot.internal.util.DeliveryStatus

@Composable
fun ChatScreen(
    modifier: Modifier = Modifier,
    messages: List<ChatMessage>,
    inputText: String,
    onInputTextChange: (String) -> Unit,
    onSendClicked: () -> Unit,
    isReverseLayout : Boolean = true
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            reverseLayout = isReverseLayout
        ) {
            items(messages) { message ->
                MoleculeChatBubble(
                    isUserSentMessage = message.isUserSentMessage,
                    deliveryStatus = DeliveryStatus.Delivered(),
                    userName = message.userName,
                    userProfileIconUrl = message.userProfileIconUrl,
                    timeStamp =message.timeStamp,
                    message = message.message
                )
            }
        }
        MoleculeChatInputBar(
            text = inputText,
            onTextChanged = onInputTextChange,
            onSendClick = onSendClicked
        )
    }
}