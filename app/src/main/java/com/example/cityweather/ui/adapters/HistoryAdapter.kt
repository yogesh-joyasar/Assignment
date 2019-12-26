package com.example.cityweather.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityweather.R
import com.example.cityweather.ui.models.AreaName
import kotlinx.android.synthetic.main.list_item_city.view.*

class HistoryAdapter(val context: Context) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    var list = mutableListOf<AreaName>()

    var onItemClick: ((pos: Int, view: View) -> Unit)? = null

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_city, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.cityName?.text = list.get(position).value
    }

    fun addAll(value: AreaName) {
        list.add(value)
        notifyDataSetChanged()
    }

    fun clear(){
        list.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view),View.OnClickListener{
        val cityName = view.idTvCityName

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            onItemClick?.invoke(adapterPosition, v)
        }
    }
}

