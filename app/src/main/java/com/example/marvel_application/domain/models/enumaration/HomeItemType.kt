package com.example.marvel_application.domain.models.enumaration

import com.example.marvel_application.R

enum class HomeItemType(val type: Int, val index: Int) {
    COMIC_ITEMS(R.layout.characteres_item, 0),
    CHARACTERS_ITEMS(R.layout.characteres_item, 1),
    CREATORS_ITEMS(R.layout.characteres_item, 2),
    EVENT_ITEMS(R.layout.characteres_item, 3),
}