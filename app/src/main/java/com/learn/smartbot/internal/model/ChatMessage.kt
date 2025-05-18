package com.learn.smartbot.internal.model

import com.learn.smartbot.internal.util.AppConstants.EMPTY_STRING
import com.learn.smartbot.internal.util.DeliveryStatus

data class ChatMessage(
    val senderId : Long? = null,
    val isSender: Boolean = false,
    val userName: String = EMPTY_STRING,
    val timeStamp: String = EMPTY_STRING,
    val message: String = EMPTY_STRING,
    val deliveryStatus: DeliveryStatus,
    val userProfileIconUrl: String? = null
)


