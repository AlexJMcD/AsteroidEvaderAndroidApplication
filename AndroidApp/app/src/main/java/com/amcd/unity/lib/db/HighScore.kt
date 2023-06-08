package com.amcd.unity.lib.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "high_scores")
data class HighScore(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "high_score") val highScore: Int?,
    @ColumnInfo(name = "date_achieved") val dateAchieved: String?
)
