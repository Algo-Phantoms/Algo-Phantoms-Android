package com.algo.phantoms.algo_phantoms.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.algo.phantoms.algo_phantoms.FragmentChangeInterface
import com.algo.phantoms.algo_phantoms.R
import com.algo.phantoms.algo_phantoms.databinding.ActivityMainBinding
import com.algo.phantoms.algo_phantoms.fragments.CodeFragment
import com.algo.phantoms.algo_phantoms.fragments.PathwayFragment
import com.algo.phantoms.algo_phantoms.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class MainActivity : AppCompatActivity(), FragmentChangeInterface {

    private var currentFragmentPosition = 0
    /* position 1 refers to "pathway" fragment
     * position 2 refers to "code" fragment
     * position 3 refers to "profile" fragment
     */
    private var startingFragmentPosition = 2

    companion object {
        private lateinit var binding: ActivityMainBinding

        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navChangeListener()

        binding.bottomNav.selectedItemId = R.id.code
        resizeIcons(R.id.code)

        changeFragment(CodeFragment())

    }

    private fun navChangeListener() {
        binding.bottomNav.setOnNavigationItemSelectedListener {
            if (binding.bottomNav.selectedItemId == it.itemId)
                return@setOnNavigationItemSelectedListener true
            when (it.itemId) {
                R.id.pathway -> {
                    currentFragmentPosition = 1
                    changeFragment(PathwayFragment())
                }
                R.id.code -> {
                    currentFragmentPosition = 2
                    changeFragment(CodeFragment())
                }
                R.id.profile -> {
                    currentFragmentPosition = 3
                    changeFragment(ProfileFragment())
                }
            }
            resizeIcons(it.itemId)
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun changeFragment(fragment: Fragment) {
        when {
            currentFragmentPosition < startingFragmentPosition -> {
                supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_left_to_right, R.anim.exit_left_to_right, R.anim.enter_right_to_left, R.anim.exit_right_to_left)
                    .replace(R.id.main_frame, fragment)
                    .commit()
                startingFragmentPosition = currentFragmentPosition
            }
            currentFragmentPosition > startingFragmentPosition -> {
                supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_right_to_left, R.anim.exit_right_to_left, R.anim.enter_left_to_right, R.anim.exit_left_to_right)
                    .replace(R.id.main_frame, fragment)
                    .commit()
                startingFragmentPosition = currentFragmentPosition
            }
            else -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_frame, fragment)
                    .commit()
            }
        }
    }

    @SuppressLint("RestrictedApi")
    private fun resizeIcons(itemId: Int) {
        val menuView = binding.bottomNav
        menuView.itemIconSize =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24f, resources.displayMetrics)
                .toInt()
        val selectedSize =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32f, resources.displayMetrics)
                .toInt()
        val iconView = menuView.findViewById<BottomNavigationItemView>(itemId)
        iconView.setIconSize(selectedSize)
    }

    override fun onBackPressed() {
        /* On pressing back button, 'main_frame' gets set to "code" fragment irrespective
         * of on which fragment back button was clicked. On further pressing the back button,
         * the main activity closes.
         */
        if (binding.bottomNav.selectedItemId == R.id.code) {
            super.onBackPressed()
            finish()
        } else {
            binding.bottomNav.selectedItemId = R.id.code
        }
    }
}