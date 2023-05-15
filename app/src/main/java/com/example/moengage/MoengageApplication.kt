package com.example.moengage

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build


/**
 * Created by Akshay Sharma on 13/05/23.
 */

public class MoengageApplication : Application() {
    val FCM_CHANNEL_ID = "FCM_CHANNEL_ID"

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val fcmChannel = NotificationChannel(
                FCM_CHANNEL_ID, "FCM_Channel", NotificationManager.IMPORTANCE_HIGH
            )
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(fcmChannel)
        }
    }
}