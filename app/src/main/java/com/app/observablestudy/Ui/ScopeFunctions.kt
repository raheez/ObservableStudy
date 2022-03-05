package com.app.observablestudy.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.observablestudy.R

class ScopeFunctions : AppCompatActivity() {

    private var  i=2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope_functions)
        testScopeFunctions()
    }

    private fun testScopeFunctions() {

        testLetFunction()
        testAlsoFunction()

    }



    private fun testLetFunction() {
        var number1: Int? = null
        number1 = 10
        val x = number1?.let {
            val number2 = it + 1
            number2
        } ?: 3
        Log.d("let_scope", "" + x)
    }


    private fun testAlsoFunction() {
        var number1: Int? = null
        number1 =10
        var y = number1.also {

            number1++
        }
        Log.d("also_scope", "number1-> " + number1)
        Log.d("also_scope", "y-> " + y)
    }

    private fun getSquaredi()=(i*i).also { i++}
}