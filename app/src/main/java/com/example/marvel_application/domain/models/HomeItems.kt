package com.example.marvel_application.domain.models

import androidx.lifecycle.LiveData

data class HomeItems(
    val comic: LiveData<List<Characters>>? = null,
    val characters: LiveData<List<Characters>>? = null,
    val creators: LiveData<List<Characters>>? = null,
    val event: LiveData<List<Characters>>? = null
)