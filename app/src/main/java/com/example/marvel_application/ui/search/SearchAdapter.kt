package com.example.marvel_application.ui.search

import com.example.marvel_application.R
import com.example.marvel_application.domain.models.Search
import com.example.marvel_application.ui.base.BaseAdapter

class SearchAdapter(item: List<Search>): BaseAdapter<Search>(item) {
    override var layoutId = R.layout.search_item

    override fun areItemSame(oldItem: Search, newItem: Search) = true
}