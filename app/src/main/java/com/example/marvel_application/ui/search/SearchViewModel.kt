package com.example.marvel_application.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvel_application.domain.repository.MarvelRepository
import com.example.marvel_application.ui.base.BaseViewModel
import com.example.marvel_application.util.Constant.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MarvelRepository
    )  : BaseViewModel() {

    val searchName = MutableLiveData<String>()

    val resentSearch = repository.getMarvelResentSearch().asLiveData(Dispatchers.IO)

    fun getResentSearchOfCharacters() {
        viewModelScope.launch {
            searchName.value?.let { repository.getSearchItem(name = it) }
            Log.i(TAG, "getResentSearchOfCharacters: ${searchName.value}")
        }
    }
}