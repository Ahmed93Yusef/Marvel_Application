package com.example.marvel_application.ui.home.adapter

import com.example.marvel_application.R
import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.ui.base.BaseAdapter
import com.example.marvel_application.ui.home.HomeInteractionListener

class CharacterAdapter(items: List<Characters>,listener: HomeInteractionListener?) : BaseAdapter<Characters>(items,listener) {
    override var layoutId = R.layout.characteres_item

    override fun areItemSame(oldItem: Characters, newItem: Characters) = true

}