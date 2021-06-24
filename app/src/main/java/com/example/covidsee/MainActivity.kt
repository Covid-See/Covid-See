package com.example.covidsee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationController()
    }

    private fun navigationController() {

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation_view)

        val navController= findNavController(R.id.container_fragment)

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.allRegionsMenuFragment,R.id.gwangjuRegionMenuFragment))
        setupActionBarWithNavController(navController,appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}