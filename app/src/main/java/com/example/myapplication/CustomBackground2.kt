package com.example.myapplication

object CustomBackground2 {
    val list = listOf<Pair<Int,Int>>(
            Pair(R.drawable.oval_blue,1),
            Pair(R.drawable.oval_green,10),
            Pair(R.drawable.oval_orange,20),
            Pair(R.drawable.oval_red,50),
            Pair(R.drawable.oval_black,Int.MAX_VALUE)
    )
    //Enum처럼 열거하여 사용할 순 있지만 각각의 요소가 어떤 의미 인지 개발자 입장에선 파악 어려움
    fun getBackground(num:Int):Int{
        for(item in list){
            if(num<=item.second) return item.first
        }
        return list[list.lastIndex].first
    }
}