package com.amcd.unity.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.lifecycleScope
import com.amcd.unity.databinding.ActivityHighScoreBinding
import com.amcd.unity.lib.db.AsteroidEvaderDatabase
import com.amcd.unity.lib.db.HighScore
import com.amcd.unity.viewmodels.KotlinUnityViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HighScoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHighScoreBinding
    private lateinit var viewModel: KotlinUnityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHighScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

       viewModel = KotlinUnityViewModel(this)

       // prefs = this.getSharedPreferences(Constants.APP_SCORE_SHARED_PREFS, Context.MODE_PRIVATE)
       // val mostRecentScore = prefs.getInt(Constants.UNITY_HIGH_SCORE_KEY, -1)

        //viewModel.saveScore(HighScore(highScore = mostRecentScore, dateAchieved = LocalDateTime.now().toString()))

        val db = AsteroidEvaderDatabase.getInstance(this)
        lifecycleScope.launch {
            val scores: List<HighScore>
            withContext(Dispatchers.IO) {
                scores = db.highScoreDao().getAll()
            }
            binding.test.text = scores.toString()
        }

        val callback = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                finish()
            }
        }

        onBackPressedDispatcher.addCallback(this, callback)
    }
}