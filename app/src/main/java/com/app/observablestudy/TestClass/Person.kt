package com.app.observablestudy.TestClass

import android.util.Log

class Person {

    var name = "ran"
    var age = 29
    var address = "al karama"


    fun displayDetails(){
        Log.d("name",""+name)
        Log.d("addresss",""+address)
        Log.d("age",""+age)
    }
}