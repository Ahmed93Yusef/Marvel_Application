package com.example.marvel_application.ui.home

import com.example.marvel_application.ui.base.BaseInteractionListener

interface HomeInteractionListener: BaseInteractionListener {
    fun onClickItem(id: Long)
}