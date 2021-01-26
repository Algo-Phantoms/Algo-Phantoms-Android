package com.algo.phantoms.algo_phantoms.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.algo.phantoms.algo_phantoms.R
import com.algo.phantoms.algo_phantoms.databinding.FragmentPathwayBinding
import com.algo.phantoms.algo_phantoms.databinding.FragmentProfileBinding

class PathwayFragment : Fragment() {

    companion object {
        private lateinit var binding : FragmentPathwayBinding
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_pathway, container, false)
        binding = FragmentPathwayBinding.bind(view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}