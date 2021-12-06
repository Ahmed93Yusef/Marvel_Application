package com.example.marvel_application.ui.comic

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel_application.domain.repository.MarvelRepository
import com.example.marvel_application.ui.base.BaseViewModel
import com.example.marvel_application.util.Constant.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicViewModel @Inject constructor(
    private val repository: MarvelRepository,
    state: SavedStateHandle
) : BaseViewModel() {

    private val characterId = state.get<Long>("characterId")
    val result = characterId?.let { repository.getMarvelCharactersById(it).asLiveData(Dispatchers.IO) }

    init {
        viewModelScope.launch {
            characterId?.let {
                repository.getMarvelCharactersById(it).collect { response ->
                    val x = response?.toData()?.name
                    Log.i(TAG, "ComicViewModelXXXXXXXSaved+++++++++++Instanse: $it")
                }
            }
        }
    }
}