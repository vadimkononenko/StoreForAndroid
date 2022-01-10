package com.ua.storeforandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ua.storeforandroid.R
import com.ua.storeforandroid.databinding.ComputerItemBinding
import com.ua.storeforandroid.databinding.PhoneItemBinding
import com.ua.storeforandroid.model.ComputerModel
import com.ua.storeforandroid.model.PhoneModel

class ComputerAdapter : RecyclerView.Adapter<ComputerAdapter.ComputerHolder>() {
    val computersList = arrayListOf<ComputerModel>()
    class ComputerHolder(item : View) : RecyclerView.ViewHolder(item) {
        var binding = ComputerItemBinding.bind(item)
        fun bind (computerModel: ComputerModel) = with(binding) {
            tvComputerTitle.text = computerModel.computerTitle
            imageBook.setImageResource(R.drawable.prod_img_example)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComputerHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.computer_item, parent, false)
        return ComputerHolder(itemView)
    }
    override fun onBindViewHolder(holder: ComputerHolder, position: Int) {
        holder.bind(computersList[position])
        //val item = phonesList[position]
        //holder.tv.text = item
        //holder.imageBook.setImageResource(R.drawable.prod_img_example)
    }
    override fun getItemCount(): Int {
        return computersList.size
    }

    fun addComputer(computerModel: ComputerModel){
        computersList.add(computerModel)
        notifyDataSetChanged()
    }
}