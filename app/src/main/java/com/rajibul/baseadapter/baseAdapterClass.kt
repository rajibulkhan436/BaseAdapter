package com.rajibul.baseadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class baseAdapterClass(var studentList:MutableList<studentDataClass>):BaseAdapter() {
    override fun getCount(): Int {
      return studentList.size
    }

    override fun getItem(position: Int): Any {
       return studentList[position]
    }

    override fun getItemId(position: Int): Long {
        return studentList[position].id?:0L
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        var view= LayoutInflater.from(p2?.context).inflate(R.layout.item_adapter,p2,false)
        var tvId = view.findViewById<TextView>(R.id.tvId)
        var tvName = view.findViewById<TextView>(R.id.tvName)
        tvId.setText("${studentList[position].id}")
        tvName.setText("${studentList[position].name}")

        return view
    }
}