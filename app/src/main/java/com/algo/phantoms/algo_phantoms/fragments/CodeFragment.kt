package com.algo.phantoms.algo_phantoms.fragments

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.algo.phantoms.algo_phantoms.R
import com.algo.phantoms.algo_phantoms.databinding.FragmentCodeBinding
import me.testica.codeeditor.SyntaxHighlightRule

class CodeFragment : Fragment() {

    companion object {
        private lateinit var binding : FragmentCodeBinding
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_code, container, false)
        binding = FragmentCodeBinding.bind(view)


        val DarkModeFlags = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        val isDarkModeOn = DarkModeFlags == Configuration.UI_MODE_NIGHT_YES

        if (isDarkModeOn) {
            binding.editor.setSyntaxHighlightRules(
                SyntaxHighlightRule("[0-9]*", "#6512c4"),
                SyntaxHighlightRule("[^A-Za-z0-9]","#F30E0B"),
                SyntaxHighlightRule("[A-Za-z]",  "#ffffff")
            )
        }
        else{
            binding.editor.setSyntaxHighlightRules(
                SyntaxHighlightRule("[0-9]*", "#6512c4"),
                SyntaxHighlightRule("[^A-Za-z0-9]","#F30E0B"),
                SyntaxHighlightRule("[A-Za-z]",  "#242322")
            )
        }



        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}