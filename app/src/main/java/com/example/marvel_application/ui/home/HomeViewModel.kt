package com.example.marvel_application.ui.home

import android.util.Log
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel_application.domain.models.HomeItem
import com.example.marvel_application.domain.repository.MarvelRepository
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
    private val characters= repository.getMarvelCharacters().asLiveData(Dispatchers.IO)
    private val comics= repository.getMarvelComic().asLiveData(Dispatchers.IO)
    private val events= repository.getMarvelEvent().asLiveData(Dispatchers.IO)

    val homeItem = listOf(characters,comics,events)

    init {
        viewModelScope.launch {
            repository.refreshItems()
            Log.i(TAG, "HomeViewModel------------characters------------: ${characters.value}")
        }
    }
}
