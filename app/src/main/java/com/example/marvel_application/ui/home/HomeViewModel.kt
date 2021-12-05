package com.example.marvel_application.ui.home

import android.util.Log
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel_application.domain.MarvelRepository
import com.example.marvel_application.ui.base.BaseViewModel
import com.example.marvel_application.util.Constant.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: MarvelRepository
) : BaseViewModel() {
    val characters= repository.getMarvelCharacters().asLiveData(Dispatchers.IO)

    init {
        viewModelScope.launch {
            repository.refreshCharacters()
            Log.i(TAG, "HomeViewModel------------characters------------: ${characters.value}")
        }
    }
}
