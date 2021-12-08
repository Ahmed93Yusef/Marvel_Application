package com.example.marvel_application.ui.home.adapter

import com.example.marvel_application.R
import com.example.marvel_application.domain.models.Event
import com.example.marvel_application.ui.base.BaseAdapter
import com.example.marvel_application.ui.home.HomeInteractionListener

class EventAdapter(items: List<Event>,listener: HomeInteractionListener?) : BaseAdapter<Event>(items,listener) {
    override var layoutId = R.layout.event_item

    override fun areItemSame(oldItem: Event, newItem: Event) = true

}