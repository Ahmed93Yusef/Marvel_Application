package com.example.marvel_application.ui.home.adapter

import com.example.marvel_application.R
import com.example.marvel_application.domain.models.Search
import com.example.marvel_application.ui.base.BaseAdapter
import com.example.marvel_application.ui.home.HomeInteractionListener

class ResentSearchAdapter(items: List<Search>, listener: HomeInteractionListener?) : BaseAdapter<Search>(items,listener) {
    override var layoutId = R.layout.search_item

    override fun areItemSame(oldItem: Search, newItem: Search) = true

}