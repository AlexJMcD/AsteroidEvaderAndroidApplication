package com.amcd.unity.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amcd.unity.lib.db.HighScore
import com.amcd.unity.lib.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class KotlinUnityViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    fun saveScore(score: HighScore) {

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.insertScore(score)
            }
        }
    }
}