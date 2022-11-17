package com.lpf.rvdemo.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder>() {

    private var list = arrayListOf<BaseItem<T>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        list.forEach {
            if (viewType == it.getItemViewType()) {
                return it.onCreateViewHolder(parent, viewType)
            }
        }
        throw RuntimeException("Wrong itemViewType")
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        list[position].onBindViewHolder(holder, position)
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return list[position].getItemViewType()
    }

    /**
     * 释放资源
     */
    override fun onViewDetachedFromWindow(holder: BaseViewHolder) {
        super.onViewDetachedFromWindow(holder)
        val position = holder.bindingAdapterPosition
        if (position < 0 || position > list.size) {
            return
        }
        list[position].releaseResource()
    }

    /**
     * 填充数据
     */
    fun setData(data: ArrayList<BaseItem<T>>) {
        list.clear()
        list = data
        notifyDataSetChanged()
    }

    /**
     * 添加单个数据
     */
    fun addData(T: BaseItem<T>) {
        list.add(T)
        val index = list.size - 1
        notifyItemChanged(index)
    }

    fun addData(index: Int, T: BaseItem<T>) {
        list.add(index, T)
        notifyItemChanged(index)
    }

    /**
     * 添加一组数据
     */
    fun addAll(data: ArrayList<BaseItem<T>>) {
        if (data.isEmpty()) {
            return
        }
        val start = list.size
        val count = data.size
        list.addAll(data)
        notifyItemRangeChanged(start, count)
    }

    fun addAll(index: Int, data: ArrayList<BaseItem<T>>) {
        //这儿做了判断，如果想自己实现可以复写
        if (index < 0 || index > list.size || data.isEmpty()) {
            return
        }
        list.addAll(index, data)
        notifyItemRangeChanged(index, data.size)
    }

    /**
     * 移除单个数据
     */
    fun remove(T: BaseItem<T>) {
        val index = list.indexOf(T)
        remove(index)
    }

    fun remove(index: Int) {
        if (index > -1) {
            list.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }
}