package com.example.marvel_application.ui.home

import com.example.marvel_application.R
import com.example.marvel_application.domain.models.HomeItem
import com.example.marvel_application.ui.base.BaseAdapter

class CharacterAdapter<T>(items: List<HomeItem<T>>, listener: HomeInteractionListener?): BaseAdapter<HomeItem<T>>(
    items = items,
    listener = listener,
    layoutId = R.layout.child_characteres_item
) {
    override fun areItemSame(oldItem: HomeItem<T>?, newItem: HomeItem<T>?) = true
}