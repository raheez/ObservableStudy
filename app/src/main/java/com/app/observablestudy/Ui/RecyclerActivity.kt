package com.app.observablestudy.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.observablestudy.ListAdapter
import com.app.observablestudy.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {


    lateinit var mBinding: ActivityRecyclerBinding
    lateinit var mLayoutManager: RecyclerView.LayoutManager
    lateinit var mAdapter : ListAdapter
    var mArrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        mArrayList.add("hello")
        mArrayList.add("hi")
        mArrayList.add("how")
        mArrayList.add("are")
        mArrayList.add("you")

        mArrayList.add("hello_m")
        mArrayList.add("hi_m")
        mArrayList.add("how_m")
        mArrayList.add("are_m")
        mArrayList.add("you_m")

        mArrayList.add("hello_mm")
        mArrayList.add("hi_mm")
        mArrayList.add("how_mm")
        mArrayList.add("are_mm")
        mArrayList.add("you_mm")

        mArrayList.add("hello_tt")
        mArrayList.add("hi_tt")
        mArrayList.add("how_tt")
        mArrayList.add("are_tt")
        mArrayList.add("you_tt")
        Log.d("array_list_size",""+mArrayList.size)


        setAdapter()
    }

    private fun setAdapter() {
        mLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        mBinding?.listRv?.layoutManager = LinearLayoutManager(this)

        mAdapter = ListAdapter(mArrayList)
        mBinding?.listRv?.adapter = mAdapter
    }
}