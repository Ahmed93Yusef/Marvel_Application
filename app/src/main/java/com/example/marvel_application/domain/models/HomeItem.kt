package com.example.marvel_application.domain.models

import com.example.marvel_application.domain.models.enumaration.HomeItemType

data class HomeItem<T>(
    val item: T,
    val itemType: HomeItemType
)
