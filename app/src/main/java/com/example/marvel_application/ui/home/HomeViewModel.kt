package com.example.marvel_application.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel_application.domain.MarvelRepository
import com.example.marvel_application.model.local.entity.CharactersEntity
import com.example.marvel_application.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: MarvelRepository
) : BaseViewModel() {
    val characters: LiveData<List<CharactersEntity>?> = repository.getMarvelCharacters().asLiveData(Dispatchers.IO)

    init {
        viewModelScope.launch {
            repository.refreshCharacters()
        }
    }
}
