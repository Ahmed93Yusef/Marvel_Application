package com.example.marvel_application.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel_application.domain.models.*
import com.example.marvel_application.domain.repository.MarvelRepository
import com.example.marvel_application.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MarvelRepository,
) : BaseViewModel(), HomeInteractionListener {

    val charactersItems: LiveData<List<Characters>> =
        repository.getMarvelCharacters().asLiveData(Dispatchers.IO)
    val comicItems: LiveData<List<Comic>> = repository.getMarvelComic().asLiveData(Dispatchers.IO)
    val creatorsItems: LiveData<List<Creators>> =
        repository.getMarvelCreators().asLiveData(Dispatchers.IO)
    val eventItems: LiveData<List<Event>> = repository.getMarvelEvent().asLiveData(Dispatchers.IO)
    val seriesItems: LiveData<List<Series>> =
        repository.getMarvelSeries().asLiveData(Dispatchers.IO)

    init {
        getCharacters()
        getComic()
        getCreators()
        getEvent()
        getSeries()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            repository.refreshCharacters()
        }
    }

    private fun getComic() {
        viewModelScope.launch {
            repository.refreshComic()
        }
    }

    private fun getCreators() {
        viewModelScope.launch {
            repository.refreshCreators()
        }
    }

    private fun getEvent() {
        viewModelScope.launch {
            repository.refreshEvent()
        }
    }

    private fun getSeries() {
        viewModelScope.launch {
            repository.refreshSeries()
        }
    }

    override fun onItemClicked(itemType: String) {

    }
}
