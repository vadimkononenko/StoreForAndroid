package com.ua.storeforandroid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ua.storeforandroid.adapter.PhoneAdapter
import com.ua.storeforandroid.R
import com.ua.storeforandroid.adapter.ComputerAdapter
import com.ua.storeforandroid.model.ComputerModel
import com.ua.storeforandroid.model.PhoneModel

class HomeFragment : Fragment(), PhoneAdapter.onItemClickListenerPhone {

    private val adapterPhone = PhoneAdapter(this)
    private val phoneList = listOf(
        PhoneModel("iPhone7", 200),
        PhoneModel("iPhone8", 300),
        PhoneModel("iPhone X",400),
        PhoneModel("iPhone Xr",600),
        PhoneModel("iPhone 11 Pro",800)
    )
    private val adapterComputer = ComputerAdapter()
    private val computerList = listOf(
        ComputerModel("Телефоны"),
        ComputerModel("Планшеты"),
        ComputerModel("Компьютеры"),
        ComputerModel("Ноутбуки"),
        ComputerModel("Наушники")
    )

    private lateinit var viewL: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewL = inflater.inflate(R.layout.fragment_home, container, false)
        return viewL
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPhone(view)
    }

    private fun initPhone(view: View){
        view.apply {
            val rvPhones : RecyclerView = view.findViewById(R.id.rv_phones)
            adapterPhone.addPhone(phoneList[0])
            adapterPhone.addPhone(phoneList[1])
            adapterPhone.addPhone(phoneList[2])
            adapterPhone.addPhone(phoneList[3])
            adapterPhone.addPhone(phoneList[4])
            rvPhones.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            rvPhones.adapter = adapterPhone

            val rvComputers : RecyclerView = view.findViewById(R.id.rv_computers)
            adapterComputer.addComputer(computerList[0])
            adapterComputer.addComputer(computerList[1])
            adapterComputer.addComputer(computerList[2])
            adapterComputer.addComputer(computerList[3])
            adapterComputer.addComputer(computerList[4])
            rvComputers.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            rvComputers.adapter = adapterComputer
        }
    }

    private fun initComputer(view: View){
        view.apply {
            val rvComputers : RecyclerView = view.findViewById(R.id.rv_computers)
            adapterComputer.addComputer(computerList[0])
            adapterComputer.addComputer(computerList[1])
            adapterComputer.addComputer(computerList[2])
            adapterComputer.addComputer(computerList[3])
            adapterComputer.addComputer(computerList[4])
            rvComputers.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            rvComputers.adapter = adapterComputer
        }
    }

    private val productFragment = ProductFragment.newInstance()

    override fun onItemClick(position: Int) {
        Toast.makeText(context, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = phoneList[position]
        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container_fragment, productFragment)?.addToBackStack(null)?.commit()
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}