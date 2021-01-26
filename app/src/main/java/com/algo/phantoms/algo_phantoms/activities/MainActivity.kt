package com.algo.phantoms.algo_phantoms.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.algo.phantoms.algo_phantoms.FragmentChangeInterface
import com.algo.phantoms.algo_phantoms.R
import com.algo.phantoms.algo_phantoms.databinding.ActivityMainBinding
import com.algo.phantoms.algo_phantoms.fragments.CodeFragment
import com.algo.phantoms.algo_phantoms.fragments.PathwayFragment
import com.algo.phantoms.algo_phantoms.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), FragmentChangeInterface {

    companion object {
        private lateinit var binding : ActivityMainBinding

        fun start(context : Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navChangeListener()

        binding.bottomNav.selectedItemId = R.id.pathway

        changeFragment(PathwayFragment())

    }

    private fun navChangeListener() {
        binding.bottomNav.setOnNavigationItemSelectedListener {
            if (binding.bottomNav.selectedItemId == it.itemId)
                return@setOnNavigationItemSelectedListener true
            when (it.itemId) {
                R.id.pathway -> {
                    changeFragment(PathwayFragment())
                }
                R.id.code -> {
                    changeFragment(CodeFragment())
                }
                R.id.profile -> {
                    changeFragment(ProfileFragment())
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_frame, fragment)
            .commit()
    }

}