package com.learn.smartbot.internal.util

object AppConstants {
    const val USER_AVATAR = "UserAvatar"
    const val EMPTY_STRING = ""
}

sealed class DeliveryStatus {
    class Seen : DeliveryStatus()
    class Delivered : DeliveryStatus()
    class NotDelivered : DeliveryStatus()
    class Error : DeliveryStatus()
}