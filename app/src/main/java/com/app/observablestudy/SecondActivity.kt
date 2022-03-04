package com.app.observablestudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("life_cycle_method","on_create_2")

    }


    override fun onRestart() {
        super.onRestart()
        Log.d("life_cycle_method","on_restart_2")
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle_method","on_start_2")

    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle_method","on_resume_2")

    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle_method","on_pause_2")

    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle_method","on_stop_2")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle_method","on_destroy_2")
    }

}