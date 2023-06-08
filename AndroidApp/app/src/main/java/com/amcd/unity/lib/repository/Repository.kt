package com.amcd.unity.lib.repository

import android.content.Context
import com.amcd.unity.lib.db.AsteroidEvaderDatabase
import com.amcd.unity.lib.db.HighScore

class Repository(context: Context) {
    private val scoreDao = AsteroidEvaderDatabase.getInstance(context).highScoreDao()

    fun insertScore(score: HighScore) {
        scoreDao.insertItem(score)
    }

    fun retrieveScores(): List<HighScore> {
        return scoreDao.getAll()
    }

    fun retrieveHighestScore(): HighScore? {
        return scoreDao.getAll().sortedByDescending {
            it.highScore
        }.firstOrNull()
    }
}