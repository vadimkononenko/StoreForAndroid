package com.ua.storeforandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ua.storeforandroid.R

internal class ComputerAdapter(private var itemsList: List<String>) :
    RecyclerView.Adapter<ComputerAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageBook: ImageView = view.findViewById(R.id.imageBook)
        var itemTextView: TextView = view.findViewById(R.id.itemTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.phone_item, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemTextView.text = item
        holder.imageBook.setImageResource(R.drawable.prod_img_example)
    }
    override fun getItemCount(): Int {
        return itemsList.size
    }
}