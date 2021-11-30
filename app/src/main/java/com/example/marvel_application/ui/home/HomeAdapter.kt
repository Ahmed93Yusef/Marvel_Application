package com.example.marvel_application.ui.home

import com.example.marvel_application.R
import com.example.marvel_application.model.remote.response.characters.Characters
import com.example.marvel_application.ui.base.BaseAdapter

class HomeAdapter(item: List<Characters>): BaseAdapter<Characters>(
    items = item, listener = null, R.layout.characteres_item)