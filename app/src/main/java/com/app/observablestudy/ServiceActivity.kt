package com.app.observablestudy

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.getSystemService
import com.app.observablestudy.Services.BackgroundServices
import com.app.observablestudy.Services.ForegroundService
import com.app.observablestudy.Services.MediaPlayerService
import com.app.observablestudy.databinding.ActivityServicesBinding

class ServiceActivity : AppCompatActivity() {


    lateinit var binding: ActivityServicesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("life_cycle_method", "on_create_2")
        initListener()
        //initiateBackgroundService()
        //initiateForegroundService()

    }

    private fun initListener() {



        binding?.startButton?.setOnClickListener {
            if (!isForeGroundServiceRunning(MediaPlayerService::class.java)) {
                val mIntent = Intent(this, MediaPlayerService::class.java)
                mIntent.apply {
                    startService(this)

                }
            }
        }

        binding?.stopButton?.setOnClickListener {
            val mIntent = Intent(this, MediaPlayerService::class.java)
            mIntent.apply {
                stopService(this)
            }
        }
    }


    private fun initiateBackgroundService() {
        val mIntent = Intent(this, BackgroundServices::class.java)
        startService(mIntent)
    }

    private fun initiateForegroundService() {
        if (!isForeGroundServiceRunning(ForegroundService::class.java)) {
            val mIntent = Intent(this, ForegroundService::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(mIntent)
            }
        }
    }

    private fun isForeGroundServiceRunning(serviceClass: Class<*>): Boolean {
        val mActivityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val mboolVal = mActivityManager?.getRunningServices(Int.MAX_VALUE)
            .any { it.service.className == serviceClass.name }
        Log.d("is_running", "" + mboolVal.toString())
        return mboolVal
    }


    override fun onRestart() {
        super.onRestart()
        Log.d("life_cycle_method", "on_restart_2")
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle_method", "on_start_2")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle_method", "on_resume_2")

    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle_method", "on_pause_2")

    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle_method", "on_stop_2")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle_method", "on_destroy_2")
    }

}