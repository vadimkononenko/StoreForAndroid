package com.ua.storeforandroid

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ua.storeforandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.container_fragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        bottomNavigationView.setupWithNavController(navController)

        //navigation menu onclick setup
        binding.apply {
            navigationMenu.setNavigationItemSelectedListener {
                //navigation menu buttons tests
                when(it.itemId) {
                    R.id.nav_item1 ->
                        Toast.makeText(this@MainActivity, "item1", Toast.LENGTH_SHORT).show()
                    R.id.nav_item2 ->
                        Toast.makeText(this@MainActivity, "item2", Toast.LENGTH_SHORT).show()
                    R.id.nav_item3 ->
                        Toast.makeText(this@MainActivity, "item3", Toast.LENGTH_SHORT).show()
                    R.id.nav_item4 ->
                        Toast.makeText(this@MainActivity, "item4", Toast.LENGTH_SHORT).show()
                    R.id.nav_item5 ->
                        Toast.makeText(this@MainActivity, "*О программе*", Toast.LENGTH_SHORT).show()
                }
                true
            }
        }
    }
}