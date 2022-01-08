package com.ua.storeforandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
//comment example
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.container_fragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        bottomNavigationView.setupWithNavController(navController)
    }
}