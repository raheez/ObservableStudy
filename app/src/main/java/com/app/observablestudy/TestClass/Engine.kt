package com.app.observablestudy.TestClass

import android.util.Log

class Engine (var engineType :String) : Person()  {

    var mCylinderCount = -1

    init {
        Log.d("inside","init_block\n")
        Log.d("engine_type",""+engineType)
        Log.d("engine_type",""+mCylinderCount)
    }


    constructor(engineType: String, _cylinderCount : Int):this(engineType){
        Log.d("inside","secondary_constructor\n")
        mCylinderCount = _cylinderCount
    }

    override var name = ""



}