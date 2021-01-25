package com.algo.phantoms.algo_phantoms.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.algo.phantoms.algo_phantoms.activities.LoginActivity
import com.algo.phantoms.algo_phantoms.R

class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        val activity = (requireActivity() as LoginActivity)
        view.findViewById<Button>(R.id.signInButton)
            .setOnClickListener { activity.launchMainActivity() }
        view.findViewById<TextView>(R.id.signUpText).setOnClickListener { activity.openSignUp() }

        return view
    }
}