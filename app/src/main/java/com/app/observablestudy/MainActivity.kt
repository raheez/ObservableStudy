package com.app.observablestudy

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

    val studyViewModel by viewModels<StudyViewModel>()
    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initListener()
        observeData()
    }

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

}