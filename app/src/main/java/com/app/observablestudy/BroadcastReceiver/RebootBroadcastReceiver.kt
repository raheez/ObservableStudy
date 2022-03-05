package com.app.observablestudy.BroadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import com.app.observablestudy.Services.ForegroundService

class RebootBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent?.action)){
            val mIntent = Intent(context,ForegroundService::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context?.startForegroundService(mIntent)
                Toast.makeText(context,"reboot received",Toast.LENGTH_SHORT).show()
            }
        }
    }
}