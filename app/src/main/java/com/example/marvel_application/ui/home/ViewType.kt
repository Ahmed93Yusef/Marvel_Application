package com.example.marvel_application.ui.home

import com.example.marvel_application.R

enum class ViewType (val id: Int, val index: Int) {
    CHARACTER(R.layout.item_home_recycler, 0),
    CHARACTERTWO(R.layout.item_home_recycler, 1),
    CHARACTERTHREE(R.layout.item_home_recycler, 2),
    CHARACTERF(R.layout.item_home_recycler, 3)
}