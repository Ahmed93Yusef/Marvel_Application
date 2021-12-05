package com.example.marvel_application.ui.home

import com.example.marvel_application.R
import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.ui.base.BaseAdapter

class HomeAdapter(item: List<Characters>, listener: HomeInteractionListener?) :
    BaseAdapter<Characters>(
        items = item,
        listener = listener,
        layoutId = R.layout.characteres_item
    ) {
    override fun areItemSame(oldItem: Characters?, newItem: Characters?) = true
}