package com.amcd.unity.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import com.amcd.unity.R
import com.amcd.unity.activities.KotlinUnityActivity
import com.amcd.unity.databinding.FragmentGameBinding
import com.amcd.unity.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime

@AndroidEntryPoint
class GameFragment : Fragment(R.layout.fragment_game) {
    private var binding: FragmentGameBinding? = null
    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGameBinding.bind(view)

        binding?.launchGameButton?.setOnClickListener {
            startActivity(Intent(context, KotlinUnityActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.getHighestScore()
        activity?.let {
            viewModel.highScore.observe(it) { score ->
                score?.let { highScore ->
                    binding?.noScoreYet?.isGone = true
                    val scoreString =
                        "Your highest score achieved is: ${highScore.highScore}. You achieved this on: ${
                            LocalDateTime.parse(highScore.dateAchieved).toLocalDate()
                        }"
                    binding?.scoreTextContainer?.isVisible = true
                    binding?.highScoreText?.text = scoreString
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}