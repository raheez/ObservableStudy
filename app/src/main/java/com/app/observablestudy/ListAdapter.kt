package com.app.observablestudy

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(var mList:ArrayList<String>): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {


    var mOncreateCount = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.adapter_list_item,parent,false)
        mOncreateCount++
        Log.d("on_create_viewholder",""+mOncreateCount)
        return ListViewHolder(mView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        Log.d("on_bindholder",""+"called")
        var mItem = mList.get(position)
        holder.mTextView.text = mItem.lowercase()

    }

    override fun getItemCount(): Int {
        return  mList.size
    }



    class ListViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){

        val mTextView :TextView = itemView.findViewById(R.id.title_tv)

    }

}