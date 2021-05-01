package com.example.myapplication

enum class CustomBackground (val res:Int,val num_lvl:Int){
    //Enum Class
    Circle_Blue(R.drawable.oval_blue,0), //0명
    Circle_Green(R.drawable.oval_green,10), // 1~10
    Circle_Orange(R.drawable.oval_orange,20), // 11~20
    Circle_Red(R.drawable.oval_red,50), // 21~50
    Circle_Black(R.drawable.oval_black,Int.MAX_VALUE); //50이상
    companion object {
        // 함수만 필요해서 object로 선
        fun getBackground(lvl: Int): Int {
            for (item in CustomBackground.values()) { // B,G,O,R,B 순서로 진
                if (lvl <= item.num_lvl) return item.res // 확진자수가 lvl 밑이면 해당 Resource를 반환
            }
            return Circle_Black.res
        }
    }
}