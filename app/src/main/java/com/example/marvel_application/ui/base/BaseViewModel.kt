package com.example.marvel_application.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.marvel_application.util.Event

abstract class BaseViewModel : ViewModel() {
    private val _navigationLiveData = MutableLiveData<Event<NavDirections>>()
    val navigationLiveData: LiveData<Event<NavDirections>> = _navigationLiveData

    fun navigate(direction: NavDirections) {
        _navigationLiveData.postValue(Event(direction))
    }
}
