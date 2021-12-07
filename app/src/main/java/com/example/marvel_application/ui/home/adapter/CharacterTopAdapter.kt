package com.example.marvel_application.ui.home.adapter

import com.example.marvel_application.R
import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.ui.base.BaseAdapter

class CharacterTopAdapter(items: List<Characters>) :
    BaseAdapter<Characters>(items) {

    override var layoutId = R.layout.characteres_item

    override fun areItemSame(oldItem: Characters, newItem: Characters) =true
}