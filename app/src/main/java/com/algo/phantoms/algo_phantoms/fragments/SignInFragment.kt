package com.algo.phantoms.algo_phantoms.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.algo.phantoms.algo_phantoms.FragmentChangeInterface
import com.algo.phantoms.algo_phantoms.activities.LoginActivity
import com.algo.phantoms.algo_phantoms.R
import com.algo.phantoms.algo_phantoms.activities.MainActivity
import com.algo.phantoms.algo_phantoms.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    companion object {
        private lateinit var binding : FragmentSignInBinding
        private lateinit var fragmentChangeInterface : FragmentChangeInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        binding = FragmentSignInBinding.bind(view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fragmentChangeInterface = context as FragmentChangeInterface

        binding.signInButton.setOnClickListener {
            MainActivity.start(requireContext())
        }

        binding.signUpText.setOnClickListener {
            fragmentChangeInterface.changeFragment(SignUpFragment())
        }

    }
}