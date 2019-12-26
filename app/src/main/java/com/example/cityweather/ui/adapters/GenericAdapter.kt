package com.example.cityweather.ui.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


abstract class GenericAdapter<T, V : View>(private val list: List<T>?) :
    RecyclerView.Adapter<GenericAdapter.ViewHolder<V>>() {

    protected abstract fun newView(context: Context, parent: ViewGroup): V

    protected abstract fun bind(t: T, view: View, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(newView(parent.context, parent))

    override fun onBindViewHolder(holder: ViewHolder<V>, position: Int) =
        bind(list!![position], holder.itemView, position)

    override fun getItemViewType(position: Int) = list!!.size

    override fun getItemId(position: Int) = list!!.size.toLong()

    override fun getItemCount() = list!!.size

    class ViewHolder<V : View>(view: V) : RecyclerView.ViewHolder(view)
}

