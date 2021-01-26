package com.algo.phantoms.algo_phantoms.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.algo.phantoms.algo_phantoms.R
import com.algo.phantoms.algo_phantoms.fragments.CodeFragment
import com.algo.phantoms.algo_phantoms.fragments.PathwayFragment
import com.algo.phantoms.algo_phantoms.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)

        bottomNav.setOnNavigationItemSelectedListener {
            if (bottomNav.selectedItemId == it.itemId)
                return@setOnNavigationItemSelectedListener true
            when (it.itemId) {
                R.id.pathway -> {
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.main_frame, PathwayFragment()
                        ).commit()
                }
                R.id.code -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.main_frame, CodeFragment()
                    ).commit()
                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.main_frame, ProfileFragment()
                    ).commit()
                }
            }
            return@setOnNavigationItemSelectedListener true
        }

        bottomNav.selectedItemId = R.id.pathway
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.main_frame, PathwayFragment()
            ).commit()

    }
}