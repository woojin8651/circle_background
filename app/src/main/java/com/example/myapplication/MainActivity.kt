package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val datalist = mutableListOf<Int>()
    private var reyclerview:RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        uiUpdate()
    }
    fun uiUpdate(){
        reyclerview = findViewById<RecyclerView>(R.id.main_recyclerview).apply {
            layoutManager = GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false)
            hasFixedSize()
            adapter = RVAdapter(datalist)
        }
        //Recyclerview 설정 gridlayout ,span = 3

        datalist.apply {
            add(1)
            add(10)
            add(24)
            add(0)
            add(102)
            add(35)
            add(17)
            add(1)
            add(111)
            add(60)
            add(20)
            add(11)
            add(35)
            add(1)
            //확진자 수라생각합시다 }

            reyclerview?.adapter?.notifyDataSetChanged()
        }
    }
}