package com.example.marvel_application.ui.base

import androidx.lifecycle.ViewModel
import com.example.marvel_application.model.repository.Repository

abstract class BaseViewModel : ViewModel() {
    protected val repository = Repository()
}
