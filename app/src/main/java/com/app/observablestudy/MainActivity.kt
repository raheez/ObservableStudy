package com.app.observablestudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.app.observablestudy.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    //region decalaration
    val studyViewModel by viewModels<StudyViewModel>()
    lateinit var mainBinding: ActivityMainBinding
    //endregion


    //region lifecyle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initListener()
        observeData()
        Log.d("life_cycle_method","on_create")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("life_cycle_method","on_restart")
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle_method","on_start")

    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle_method","on_resume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle_method","on_pause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle_method","on_stop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle_method","on_destroy")
    }


    //endregion


    //region methods
    private fun initListener() {
        mainBinding?.liveDataButton?.setOnClickListener {
            studyViewModel.triggerLiveData()

        }

        mainBinding?.stateFlowButton?.setOnClickListener {
            studyViewModel.triggerStateFlow()
        }

        mainBinding?.sharedFlowButton?.setOnClickListener {
            studyViewModel.triggerSharedFlow()
        }

        mainBinding?.flowButton?.setOnClickListener {
            lifecycleScope?.launch {
                studyViewModel.triggerFlow()?.collectLatest {
                    mainBinding?.flowTv?.setText(it)
                    Log.d("flow", "updated")
                }
            }
        }

        mainBinding?.nextButton?.setOnClickListener {
            val mIntent = Intent(this,SecondActivity::class.java)
            startActivity(mIntent)
        }
    }


    private fun observeData() {
        lifecycleScope?.launch {
            studyViewModel?._Livedata?.observe(this@MainActivity, Observer {
                mainBinding?.liveDataTv?.setText(it)
                Log.d("live_data", "updated")
            })
        }

        lifecycleScope?.launchWhenStarted {
            studyViewModel?.stateFlow?.collectLatest {
                mainBinding?.stateFlowTv?.setText(it)
                Log.d("state_flow", "updated")

            }
        }

        lifecycleScope?.launchWhenStarted {
            studyViewModel?.sharedFlow?.collectLatest {
                mainBinding?.sharedFlowTv?.setText(it)
                Snackbar.make(mainBinding.root,it,Snackbar.LENGTH_SHORT).show()
                Log.d("shared_flow", "updated")

            }
        }

    }
    //endregion
}