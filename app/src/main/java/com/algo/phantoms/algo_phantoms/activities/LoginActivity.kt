package com.algo.phantoms.algo_phantoms.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.algo.phantoms.algo_phantoms.R
import com.algo.phantoms.algo_phantoms.fragments.SignInFragment
import com.algo.phantoms.algo_phantoms.fragments.SignUpFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        openSignIn()
    }

    fun openSignIn() {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, SignInFragment())
            .commit()
    }

    fun openSignUp() {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, SignUpFragment())
            .commit()
    }

    fun launchMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}