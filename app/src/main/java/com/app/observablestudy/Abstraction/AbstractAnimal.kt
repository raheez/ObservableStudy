package com.app.observablestudy.TestClass

import android.util.Log

abstract class AbstractAnimal {

    //abstract properties and method should be defined in subclass
    abstract var mDog: String
    var mName: String = ""
    abstract fun testMethod()
    open fun testOpenMethod(){
        Log.d("test_open","from super_class")
    }

    //final method will not be inherited
    fun testFinalMethod(){

    }

}

class TestAnimal : AbstractAnimal() {

    //abstract properties and method should be defined in subclass
    override var mDog: String = "dog"

    //abstract methods
    override fun testMethod() {

    }

    //open method will be inherited
    override fun testOpenMethod() {
        Log.d("test_open","from sub_class")
        super.testOpenMethod()
    }
    //final method will not be inherited

}