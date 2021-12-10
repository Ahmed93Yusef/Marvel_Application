package com.example.marvel_application.ui.comic

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.asLiveData
import com.example.marvel_application.domain.repository.MarvelRepository
import com.example.marvel_application.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class ComicViewModel @Inject constructor(
    private val repository: MarvelRepository,
    state: SavedStateHandle,
) : BaseViewModel() {

    private val comicId = state.get<Long>("comicId")
    val result = comicId?.let { repository.getMarvelComicById(it).asLiveData(Dispatchers.IO) }

}