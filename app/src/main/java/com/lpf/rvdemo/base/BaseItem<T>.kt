package com.lpf.rvdemo.base

import android.view.LayoutInflater
import android.view.ViewGroup
import com.lpf.rvdemo.`interface`.Item

abstract class BaseItem<T>: Item {

    protected var list = arrayListOf<T>()

    fun setData(data: ArrayList<T>) {
        list = data
    }

    /**
     * 这儿用xml的id作为默认type，也可以自定义
     */
    override fun getItemViewType(): Int = getLayoutResId()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(getLayoutResId(), parent, false)
        return BaseViewHolder(view)
    }
}