package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(val list:List<Int>): RecyclerView.Adapter<RVAdapter.ViewHolder>(){

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val item = itemView.findViewById<ConstraintLayout>(R.id.rv_item)
        val num = itemView.findViewById<TextView>(R.id.rc_num)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_sample,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //확진자 수에 따른 Custom Background를 주기 위해 EnumClass를 활용하였다.
        holder.item.setBackgroundResource(CustomBackground.getBackground(list[position]))
        holder.num.text = list[position].toString()
    }
}