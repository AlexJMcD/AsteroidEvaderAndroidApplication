package com.amcd.unity.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amcd.unity.lib.db.AsteroidEvaderDatabase
import com.amcd.unity.lib.db.HighScore
import com.amcd.unity.lib.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class KotlinUnityViewModel(context: Context): ViewModel() {

    private val db = AsteroidEvaderDatabase.getInstance(context)
    private val repository: Repository = Repository(db.highScoreDao())

    fun saveScore(score: HighScore) {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.insertScore(score)
            }
        }
    }
}