package com.amcd.unity.lib.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HighScoreDao {
    @Query("SELECT * FROM high_scores")
     fun getAll(): List<HighScore>

    @Query("SELECT * FROM high_scores WHERE uid = :id LIMIT 1")
    fun getById(id: Int): HighScore

    @Query("SELECT MAX(high_score) AS score FROM high_scores")
    fun getHighestScore(): HighScore

    @Delete
    fun delete(score: HighScore)

    @Insert
    fun insertAll(vararg scores: HighScore)

    @Insert
    fun insertItem(score: HighScore)
}