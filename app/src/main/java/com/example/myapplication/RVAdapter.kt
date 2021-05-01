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

        //holder.item.setBackgroundResource(CustomBackground2.getBackground(list[position]))
        //같은 방식으로 object형으로 만든 것이다
        //위의 코드와 교체해도 동작은 문제없음

        /*
         object형과의 차이점은 특정한 background를 골라서 사용할때
         holder.item.setBackgroundResource(CustomBackground.Circle_Black.res)
         이렇게 변수명이 어떤 의미 인지 않 수 있음

         object형의 경우는
         holder.item.setBackgroundResource(CustomBackground2.list[0].first)
         이처럼 어떤 의미인지 모름 : 이 색이 무슨 색인가?
        */
        holder.num.text = list[position].toString()
    }
}