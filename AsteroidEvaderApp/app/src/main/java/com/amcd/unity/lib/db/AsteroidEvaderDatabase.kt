package com.amcd.unity.lib.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HighScore::class], version = 2, exportSchema = false)
abstract class AsteroidEvaderDatabase: RoomDatabase() {
    abstract fun highScoreDao(): HighScoreDao

    companion object {
        private const val DATABASE_NAME = "ASTEROID_DB"

        @Volatile
        private var db: AsteroidEvaderDatabase? = null

        fun getInstance(context: Context): AsteroidEvaderDatabase {
            return db ?: synchronized(this) {
                val instance = Room.databaseBuilder(context, AsteroidEvaderDatabase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
                db = instance
                instance
            }
        }
    }
}