package com.lpf.rvdemo.base

import android.util.SparseArray
import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val views = SparseArray<View>()

    @Suppress("UNCHECKED_CAST")
    protected fun <V: View> getView(@IdRes viewId: Int): V? {
        var view = views[viewId]
        if (view == null) {
            view = itemView.findViewById(viewId)
            if (view == null) return null
            views[viewId] = view
        }
        return view as V
    }

}