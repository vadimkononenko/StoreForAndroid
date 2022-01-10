package com.ua.storeforandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ua.storeforandroid.R
import com.ua.storeforandroid.databinding.PhoneItemBinding
import com.ua.storeforandroid.model.PhoneModel

class PhoneAdapter(private val listener: onItemClickListenerPhone) :
    RecyclerView.Adapter<PhoneAdapter.PhoneHolder>() {
    val phonesList = arrayListOf<PhoneModel>()

    inner class PhoneHolder(item: View) : RecyclerView.ViewHolder(item), View.OnClickListener {
        var binding = PhoneItemBinding.bind(item)
        fun bind(phoneModel: PhoneModel) = with(binding) {
            tvPhoneTitle.text = phoneModel.phoneTitle
            tvPhonePrice.text = phoneModel.phonePrice.toString()
            imageBook.setImageResource(R.drawable.prod_img_example)
        }

        init {
            item.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface onItemClickListenerPhone {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.phone_item, parent, false)
        return PhoneHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhoneHolder, position: Int) {
        holder.bind(phonesList[position])
    }

    override fun getItemCount(): Int {
        return phonesList.size
    }

    fun addPhone(phoneModel: PhoneModel) {
        phonesList.add(phoneModel)
        notifyDataSetChanged()
    }
}