package com.example.marvel_application.ui.home

import com.example.marvel_application.R

enum class HomeItemsType (val id: Int, val index: Int) {
    CHARACTER(R.layout.item_home_character_recycler, 0),
    COMIC(R.layout.item_home_comic_recycler, 1),
    CREATORS(R.layout.item_home_creators_recycler, 2),
    EVENT(R.layout.item_home_event_recycler, 3),
    SERIES(R.layout.item_home_series_recycler, 4)
}