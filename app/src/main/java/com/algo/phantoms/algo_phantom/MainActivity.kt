package com.algo.phantoms.algo_phantom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import meow.bottomnavigation.MeowBottomNavigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<MeowBottomNavigation>(R.id.bottom_nav)
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_pathway))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_code))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_person))

        bottomNavigation.show(1)
    }
}