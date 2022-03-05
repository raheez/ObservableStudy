package com.app.observablestudy.Services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MediaPlayerService :Service() {

    lateinit var mPlayer :MediaPlayer
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mPlayer = MediaPlayer()
        mPlayer = MediaPlayer.create(this,Settings.System.DEFAULT_RINGTONE_URI)
        mPlayer.isLooping = true
        mPlayer.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPlayer.stop()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}