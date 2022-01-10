package com.ua.storeforandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ua.storeforandroid.adapter.PhoneAdapter
import com.ua.storeforandroid.R

class HomeFragment : Fragment() {

    private val itemsList1 = ArrayList<String>()
    private val itemsList2 = ArrayList<String>()
    private lateinit var phoneAdapter: PhoneAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        phoneAdapter = PhoneAdapter(itemsList1)
        val layoutManager1 = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager1
        recyclerView.adapter = phoneAdapter
        prepareItems1()

        val rvComputers: RecyclerView = view.findViewById(R.id.rv_computers)
        phoneAdapter = PhoneAdapter(itemsList2)
        val layoutManager2 = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        rvComputers.layoutManager = layoutManager2
        rvComputers.adapter = phoneAdapter
        prepareItems2()
    }

    private fun prepareItems1() {
        itemsList1.add("Item 1")
        itemsList1.add("Item 2")
        itemsList1.add("Item 3")
        itemsList1.add("Item 4")
        phoneAdapter.notifyDataSetChanged()
    }

    private fun prepareItems2() {
        itemsList2.add("Item 1")
        itemsList2.add("Item 2")
        itemsList2.add("Item 3")
        itemsList2.add("Item 4")
        phoneAdapter.notifyDataSetChanged()
    }
}