package com.app.observablestudy.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.app.observablestudy.R
import com.app.observablestudy.TestClass.Bike
import com.app.observablestudy.TestClass.Engine
import com.app.observablestudy.TestClass.Person

class ScopeFunctionsActivity : AppCompatActivity() {

    private var i = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scope_functions)
        //testScopeFunctions()
        testDataClass()
    }

    private fun testDataClass() {

        val mCBR1 = Bike("CBR")
        val mCBR2 = Bike("CBR")

        val mAMG1 = Engine("AMG")
        val mAMG2 = Engine("AMG")

         if (mCBR1.equals(mCBR2))
         {
             Log.d("data_class_bool_val","true")
         }else{
             Log.d("data_class_bool_val","false")
         }

         if (mAMG1.equals(mAMG2))
         {
             Log.d("class_bool_val","true")
         }else{
             Log.d("class_bool_val","false")
         }

    }

    private fun testScopeFunctions() {
        testLetFunction()
        testAlsoFunction()
        testApplyFunction()
        testRunFunciton()
        testWithFunciton()

    }

    private fun testWithFunciton() {

        var mPerson: Person? = null
//        var mPerson = Person()

        with(mPerson) {
            this?.name = "gautham"
            this?.age = 26
            this?.address = "palakkad"
            Log.d("person_details", "with_scope-->\n")
            mPerson?.displayDetails()

        }

    }

    private fun testRunFunciton() {
        var mPerson: Person? = null
        mPerson?.run {
            name = "ajas"
            age = 35
            address = "kochi"
            Log.d("run scope", "display details")
            Log.d("person_details", "run_scope-->\n")
            this.displayDetails()
        }


    }

    private fun testApplyFunction() {
        val list = mutableListOf<Int>(1, 2, 3, 4, 5, 10, 20)
        var a = list?.apply {
            list.add(10)
        }

        val person = Person()
        var mPerson = person?.apply {
            name = "junaid"
            address = "edappal"
            age = 33
        }

        mPerson?.also {
            mPerson.displayDetails()
        }
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
        var list = mutableListOf<Int>(1, 2, 3)
        var a = list
        a = list?.also {
            it.add(10)
            it.add(100)
            it.add(1000)
            it.remove(2)
        }
    }

    private fun getSquaredi() = (i * i).also { i++ }
}