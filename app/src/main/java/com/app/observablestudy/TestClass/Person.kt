package com.app.observablestudy.TestClass

import android.util.Log

open class Person {

    open var name = "ran"
    var age = 29
    var address = "al karama"
    open var xyz = "al karama"


    open fun displayDetails() {
        Log.d("name", "" + name)
        Log.d("addresss", "" + address)
        Log.d("age", "" + age)
    }


    fun xyzMethod(){

    }

}