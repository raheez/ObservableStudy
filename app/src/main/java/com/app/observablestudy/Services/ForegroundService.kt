package com.app.observablestudy.Services

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.app.observablestudy.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ForegroundService : Service() {

    @SuppressLint("NewApi")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        CoroutineScope(Dispatchers.Default).launch {
            while (true) {
                Log.d("service_task", "service happening")
                delay(3000)
            }
        }

        val mChannelId = "notification_channel"
        var mChannel = NotificationChannel(
            mChannelId,
            mChannelId,
            NotificationManager.IMPORTANCE_LOW
        )

        getSystemService(NotificationManager::class.java).createNotificationChannel(mChannel)
        var notification =  Notification.Builder(this,mChannelId).setContentText("service is running").setContentTitle("service is enabled")
            .setSmallIcon(R.drawable.ic_launcher_background)
        startForeground(1000,notification.build())

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}