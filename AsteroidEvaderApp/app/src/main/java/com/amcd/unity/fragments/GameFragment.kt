package com.amcd.unity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.amcd.unity.R
import com.amcd.unity.databinding.FragmentGameBinding


class GameFragment : Fragment(R.layout.fragment_game) {
    private var binding: FragmentGameBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGameBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}