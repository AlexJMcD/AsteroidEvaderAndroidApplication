package com.amcd.unity.lib.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.amcd.unity.lib.db.AsteroidEvaderDatabase
import com.amcd.unity.lib.db.HighScore
import com.amcd.unity.lib.db.HighScoreDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val scoreDao: HighScoreDao) {

    fun insertScore(score: HighScore) {
        scoreDao.insertItem(score)
    }

    fun retrieveScores(): List<HighScore> {
        return scoreDao.getAll()
    }
}