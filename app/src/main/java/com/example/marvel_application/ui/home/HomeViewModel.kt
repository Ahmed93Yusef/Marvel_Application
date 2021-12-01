package com.example.marvel_application.ui.home

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel_application.domain.MarvelRepository
import com.example.marvel_application.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: MarvelRepository
): BaseViewModel() {
 val characters = repository.getMarvelCharacters().asLiveData()
    init {
        viewModelScope.launch {
            repository.getMarvelCharacters().collect {
            }
        }

    }
}
