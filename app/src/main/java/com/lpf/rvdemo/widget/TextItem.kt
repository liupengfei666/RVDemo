package com.lpf.rvdemo.widget

import com.lpf.rvdemo.R
import com.lpf.rvdemo.base.BaseItem
import com.lpf.rvdemo.base.BaseViewHolder

class TextItem(list: List<String>): BaseItem<List<String>>() {

    override fun getLayoutResId(): Int = R.layout.item_text_normal

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

    }

    override fun releaseResource() {
        TODO("Not yet implemented")
    }
}