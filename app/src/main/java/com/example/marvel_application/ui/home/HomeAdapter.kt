package com.example.marvel_application.ui.home

import com.example.marvel_application.R
import com.example.marvel_application.model.local.entity.CharactersEntity
import com.example.marvel_application.ui.base.BaseAdapter

class HomeAdapter(item: List<CharactersEntity>, listener: HomeInteractionListener?) :
    BaseAdapter<CharactersEntity>(
        items = item,
        listener = listener,
        layoutId = R.layout.characteres_item
    )