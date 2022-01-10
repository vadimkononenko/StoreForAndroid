package com.ua.storeforandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ua.storeforandroid.databinding.CartItemBinding

class CartAdapter : RecyclerView.Adapter<CartAdapter.PlantHolder>() {
    val plantList = arrayListOf<Plant>()
    class PlantHolder(item : View): RecyclerView.ViewHolder(item) {
        val binding = CartItemBinding.bind(item)
        fun bind (plant: Plant) = with(binding){
            tvTitle.text = plant.productTitle
            tvPrice.text = plant.productPrice.toString()


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    override fun getItemCount(): Int {
        return plantList.size
    }
    fun addPlant (plant : Plant){
        plantList.add(plant)
        notifyDataSetChanged()
    }

}