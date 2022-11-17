package com.lpf.rvdemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lpf.rvdemo.R
import com.lpf.rvdemo.base.BaseAdapter
import com.lpf.rvdemo.widget.TextItem

class TextListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_list)
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val adapter = BaseAdapter<TextItem>()
        recyclerView.adapter = adapter
        adapter.setData(getList())
    }

    private fun getList(): List<TextItem> {
        val list = arrayListOf<TextItem>()
        for (index in 0..20) {
            list.add("普通列表$index")
        }
        return list
    }
}