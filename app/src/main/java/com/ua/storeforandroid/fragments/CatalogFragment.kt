package com.ua.storeforandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ua.storeforandroid.adapter.CatalogAdapter
import com.ua.storeforandroid.R

class CatalogFragment : Fragment() {
    private val itemsList = ArrayList<String>()
    private lateinit var catalogAdapter: CatalogAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvCatalog: RecyclerView = view.findViewById(R.id.rv_catalog)
        catalogAdapter = CatalogAdapter(itemsList)
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvCatalog.layoutManager = layoutManager
        rvCatalog.adapter = catalogAdapter
        prepareItems()
    }
    private fun prepareItems() {
        itemsList.add("Телефоны")
        itemsList.add("Планшеты")
        itemsList.add("Компьютеры")
        itemsList.add("Ноутбуки")
        itemsList.add("Наушники")
        itemsList.add("Мышки")
        itemsList.add("Клавиратуры")
        itemsList.add("Мониторы")
        catalogAdapter.notifyDataSetChanged()
    }
}