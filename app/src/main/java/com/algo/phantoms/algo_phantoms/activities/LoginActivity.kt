package com.algo.phantoms.algo_phantoms.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.algo.phantoms.algo_phantoms.FragmentChangeInterface
import com.algo.phantoms.algo_phantoms.R
import com.algo.phantoms.algo_phantoms.databinding.ActivityLoginBinding
import com.algo.phantoms.algo_phantoms.fragments.SignInFragment
import com.algo.phantoms.algo_phantoms.fragments.SignUpFragment

class LoginActivity : AppCompatActivity(), FragmentChangeInterface {

    companion object {
        private lateinit var binding: ActivityLoginBinding

        fun start(context : Context) {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFragment(SignInFragment())

    }

    override fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }

}