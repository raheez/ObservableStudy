package com.app.observablestudy.Ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.app.observablestudy.FirstFragment
import com.app.observablestudy.R
import com.app.observablestudy.SecondFragment
import com.app.observablestudy.databinding.ActivityFragmentBinding
import com.app.observablestudy.databinding.ActivityMainBinding

class FragmentActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val mFirstFragment = FirstFragment()
        mainBinding?.fragOneButton?.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.frame_layout, mFirstFragment)
                    .addToBackStack(null)
                commit()
            }
        }

        initListener()
    }

    private fun initListener() {
        val mFirstFragment = FirstFragment()
        mainBinding?.fragOneButton?.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout, mFirstFragment)
                    .addToBackStack(null)
                commit()
            }
        }

        val mSecondFragment = SecondFragment()
        mainBinding?.fragTwoButton?.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout, mSecondFragment)
                    .addToBackStack(null)
                commit()
            }
        }
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }


    override fun onStart() {
        super.onStart()
    }


}