package com.example.traveguide.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.traveguide.R
import com.example.traveguide.data.response.TipsResponseItem

class TipsAdapter(private val listTips: List<TipsResponseItem>?) : RecyclerView.Adapter<TipsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_tips, viewGroup, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvItemName.text = listTips?.get(position)?.title.toString()
        viewHolder.tvItemDesc.text = listTips?.get(position)?.content.toString()
    }
    override fun getItemCount(): Int {
        return listTips?.size ?: 0
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvItemName: TextView = view.findViewById(R.id.tv_item_name)
        val tvItemDesc: TextView = view.findViewById(R.id.tv_item_description)
    }
}