package com.example.traveguide.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.traveguide.R
import com.example.traveguide.data.response.HomeResponseItem

class HomeAdapter(private val listHome: List<HomeResponseItem>?) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_home, viewGroup, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvPlace.text = listHome?.get(position)?.place.toString()
        viewHolder.tvCity.text = listHome?.get(position)?.city.toString()
        viewHolder.tvRating.text = listHome?.get(position)?.rating.toString()
    }
    override fun getItemCount(): Int {
        return listHome?.size ?: 0
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvPlace: TextView = view.findViewById(R.id.tv_place)
        val tvCity: TextView = view.findViewById(R.id.tv_city)
        val tvRating: TextView = view.findViewById(R.id.tv_rating)
    }
}