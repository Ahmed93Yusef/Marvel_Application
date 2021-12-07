package com.example.marvel_application.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.domain.repository.MarvelRepository
import com.example.marvel_application.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: MarvelRepository,
) : BaseViewModel() {
    val characters = repository.getMarvelCharacters().asLiveData(Dispatchers.IO)

    val homeItems = MutableLiveData<List<Characters>>()

    init {
        viewModelScope.launch {
            repository.refreshCharacters()
            repository.getMarvelCharacters().collect {
                homeItems.postValue(it)
            }
        }
    }
}
