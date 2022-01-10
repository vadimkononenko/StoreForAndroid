package com.ua.storeforandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ua.storeforandroid.adapter.CartAdapter
import com.ua.storeforandroid.model.Plant
import com.ua.storeforandroid.R

class CartFragment : Fragment() {
    private val adapter = CartAdapter()
    private val titleList = listOf("Ноутбук", "Компьютер", "Телевизор", "Приставка", "Телефон")
    private val priceList = listOf(300, 200, 500, 200, 400)
    private var index = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)

    }
    private fun init(view: View){
        view.apply {
            val rcView : RecyclerView = view.findViewById(R.id.rcView)
            val button2 : Button = view.findViewById(R.id.button2)
            val total : TextView = view.findViewById(R.id.total)
            rcView.layoutManager = LinearLayoutManager(context)
            rcView.adapter = adapter
            var tPrice = 0
            button2.setOnClickListener {
                if(index > 4) index = 0
                val plant = Plant(titleList[index], priceList[index])
                adapter.addPlant(plant)
                tPrice += priceList[index]
                total.text = "Цена: $tPrice"
                index++

            }
        }
    }
}