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
        //현재 개발중인 코로나 어플이 공공데이터 API를 통한 지역별 추가감염자 수를 가져와서
        //지역별 추가확진자에 따른 경고 배경을 생각해 보게 되었다.
        //마치 미세먼지 수치가 높으면 배경이 빨게지는 느낌

        //확진자 수에 따른 Custom Background를 주기 위해 EnumClass를 활용하였다.
        holder.item.setBackgroundResource(CustomBackground.getBackground(list[position]))

        //holder.item.setBackgroundResource(CustomBackground2.getBackground(list[position]))
        //같은 방식으로 Enum이 아닌 object형으로 만든 것이다
        //위의 코드와 교체해도 동작은 문제없음

        /*
         object형과의 차이점은 특정한 background를 골라서 사용할때
         holder.item.setBackgroundResource(CustomBackground.Circle_Black.res)
         이렇게 변수명이 어떤 의미 인지  수 있음
         즉 Enum은 특정 배열의 각각의 item이 고유한 이름을 가져 개발자에게 변수적 요소를 이해하기 쉽게 하고
         다른 상황에서도 활용할 수 있는 통일성을 제공함

         object형의 경우는
         holder.item.setBackgroundResource(CustomBackground2.list[0].first)
         이처럼 어떤 의미인지 모름 : 이 색이 무슨 색인가?
        */
        holder.num.text = list[position].toString()
    }
}