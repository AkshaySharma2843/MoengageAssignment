package com.example.moengage.notification

import android.R
import android.app.Notification
import android.app.NotificationManager
import android.graphics.Color
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage



/**
 * Created by Akshay Sharma on 13/05/23.
 */

class FirebaseMessagingService : FirebaseMessagingService() {
    private val TAG = "FirebaseMessaging"
    private val FCM_CHANNEL_ID = "FCM_CHANNEL_ID"

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d(TAG, "onMessageReceived: called")
        Log.d(TAG, "onMessageReceived: Message received from: " + remoteMessage.from)
        if (remoteMessage.notification != null) {
            val title = remoteMessage.notification!!.title
            val body = remoteMessage.notification!!.body
            val notification: Notification = NotificationCompat.Builder(this, FCM_CHANNEL_ID)
                .setSmallIcon(R.drawable.btn_star)
                .setContentTitle(title)
                .setContentText(body)
                .setColor(Color.BLUE)
                .build()
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(1002, notification)
        }
        if (remoteMessage.data.size > 0) {
            Log.d(TAG, "onMessageReceived: Data: " + remoteMessage.data.toString())
        }
    }

    override fun onDeletedMessages() {
        super.onDeletedMessages()
        Log.d(TAG, "onDeletedMessages: called")
    }

    override fun onNewToken(s: String) {
        super.onNewToken(s)
        Log.d(TAG, "onNewToken: called")
        //upload this token on the app server
    }
}