package com.amcd.unity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isGone
import androidx.fragment.app.activityViewModels
import com.amcd.unity.R
import com.amcd.unity.databinding.FragmentScoreBinding
import com.amcd.unity.lib.recyclerviewadapters.ScoreTableAdapter
import com.amcd.unity.viewmodels.MainViewModel


class ScoreFragment : Fragment(R.layout.fragment_score) {
    private var binding: FragmentScoreBinding? = null
    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentScoreBinding.bind(view)

        viewModel.getSortedScoreList()
        activity?.let { activity ->
            viewModel.sortedScoreList.observe(activity){scoreList ->
                if(scoreList.isNullOrEmpty()) return@observe
                binding?.noGamesCompletedText?.isGone = true
                binding?.scoreRecyclerView?.adapter = ScoreTableAdapter(scoreList)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}