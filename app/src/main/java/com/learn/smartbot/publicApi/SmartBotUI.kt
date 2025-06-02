package com.learn.smartbot.publicApi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.learn.smartbot.internal.model.ChatMessage
import com.learn.smartbot.internal.ui.atom.VerticalSpace16
import com.learn.smartbot.internal.ui.molecule.MoleculeChatBubble
import com.learn.smartbot.internal.ui.molecule.MoleculeChatInputBar
import com.learn.smartbot.internal.util.AppConstants.EMPTY_STRING
import com.learn.smartbot.internal.util.DeliveryStatus

@Composable
fun SmartBotUI(
    modifier: Modifier = Modifier,
    theme: ChatTheme = ChatTheme(),
    messages: List<ChatMessage>,
    onSendMessage: (String) -> Unit,
    isReverseLayout: Boolean = false
) {
    var inputText by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            reverseLayout = isReverseLayout
        ) {
            items(messages) { message ->
                Column {
                    MoleculeChatBubble(
                        isUserSentMessage = message.isUserSentMessage,
                        message = message.message,
                        deliveryStatus = DeliveryStatus.Delivered(),
                        userProfileIconUrl = message.userProfileIconUrl,
                        timeStamp = message.timeStamp,
                        userName = message.userName ?: EMPTY_STRING,
                    )
                    VerticalSpace16()
                }
            }
        }

        MoleculeChatInputBar(
            text = inputText,
            onTextChanged = { inputText = it },
            onSendClick = {
                if (inputText.isNotBlank()) {
                    onSendMessage(inputText)
                    inputText = ""
                }
            }
        )
    }
}