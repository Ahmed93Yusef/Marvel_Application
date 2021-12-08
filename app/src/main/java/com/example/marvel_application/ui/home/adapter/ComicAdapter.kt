package com.example.marvel_application.ui.home.adapter

import com.example.marvel_application.R
import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.domain.models.Comic
import com.example.marvel_application.model.local.entity.ComicEntity
import com.example.marvel_application.ui.base.BaseAdapter
import com.example.marvel_application.ui.home.HomeInteractionListener

class ComicAdapter(items: List<Comic>,listener: HomeInteractionListener?) : BaseAdapter<Comic>(items,listener) {
    override var layoutId = R.layout.comic_item

    override fun areItemSame(oldItem: Comic, newItem: Comic) = true

}