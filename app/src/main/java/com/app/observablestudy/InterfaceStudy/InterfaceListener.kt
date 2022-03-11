package com.app.observablestudy.TestClass

import android.util.Log

interface InterfaceListener { //an instance cannot be created

    //var name :String = "hi" cannot be initialised inside interface
    abstract var name :String //by default its abstract

    abstract fun property() //by default its abstract


    fun onClick(){//normal method ->public and open by default
        Log.d("onCLick","Interface_Listener")
    }
}

interface SecondInterface{

    fun onClick(){//normal method ->public and open by default
        Log.d("onCLick","second_interface")
    }

}

class CustomButton :InterfaceListener,SecondInterface{

    //all properties and members of interface should be implemented
    override var name: String = "hi"
    override fun property() {
    }

    override fun onClick() {
        super<InterfaceListener>.onClick()
        super<SecondInterface>.onClick()
    }

}