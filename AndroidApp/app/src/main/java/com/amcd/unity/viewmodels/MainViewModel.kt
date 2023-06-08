package com.amcd.unity.viewmodels

import androidx.lifecycle.MutableLiveData
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
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    var highScore: MutableLiveData<HighScore?> = MutableLiveData()
    var sortedScoreList: MutableLiveData<List<HighScore>> = MutableLiveData()

    fun getHighestScore() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                highScore.postValue(repository.retrieveHighestScore())
            }
        }
    }

    fun getSortedScoreList() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val scores = repository.retrieveScores()
                sortedScoreList.postValue(scores.sortedByDescending { it.highScore })
            }
        }
    }
}