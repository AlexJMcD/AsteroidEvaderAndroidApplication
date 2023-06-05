package com.amcd.unity.activities

import android.os.Bundle
import com.amcd.unity.lib.db.HighScore
import com.amcd.unity.viewmodels.KotlinUnityViewModel
import com.unity3d.player.UnityPlayerActivity
import java.time.LocalDateTime

class KotlinUnityActivity: UnityPlayerActivity() {
    private lateinit var viewModel: KotlinUnityViewModel

    /*override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }*/

    // Make sure the use this variation of onCreate, when you type onCreate... Android studio may auto fill
    // the wrong version of onCreate e.g. the version shown above.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setInstance(this)

        viewModel = KotlinUnityViewModel(this)
    }

    fun saveScoreData(score: Int) {
        viewModel.saveScore(HighScore(highScore = score, dateAchieved = LocalDateTime.now().toString()))
    }

    /**
     * You can only call static functions from unity c# scripts.
     * If you want to use the activity context, for example to initiate a database save, you need to provide
     * an instance of the activity to static functions.
     */
    companion object {
        private lateinit var instance: KotlinUnityActivity

        @JvmStatic
        fun setInstance(instance: KotlinUnityActivity) {
            this.instance = instance
        }

        // Called from c# scripts in the unity files.
        @JvmStatic
        fun saveScore(score: Int) {
            instance.saveScoreData(score)
        }
    }
}