package com.lpf.rvdemo.`interface`

import android.view.ViewGroup
import com.lpf.rvdemo.base.BaseViewHolder

interface Item {

    /**
     * 获取xml
     */
    fun getLayoutResId(): Int

    /**
     * 获取item类型
     */
    fun getItemViewType(): Int

    /**
     * 创建ViewHolder
     */
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder

    /**
     * 绑定ViewHolder
     */
    fun onBindViewHolder(holder: BaseViewHolder, position: Int)

    /**
     * 释放资源
     */
    fun releaseResource()
}