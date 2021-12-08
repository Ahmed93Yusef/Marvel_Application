package com.example.marvel_application.ui.home.adapter

import com.example.marvel_application.R
import com.example.marvel_application.domain.models.Creators
import com.example.marvel_application.ui.base.BaseAdapter
import com.example.marvel_application.ui.home.HomeInteractionListener

class CreatorsAdapter(items: List<Creators>,listener: HomeInteractionListener?) : BaseAdapter<Creators>(items,listener) {
    override var layoutId = R.layout.creators_item

    override fun areItemSame(oldItem: Creators, newItem: Creators) = true

}