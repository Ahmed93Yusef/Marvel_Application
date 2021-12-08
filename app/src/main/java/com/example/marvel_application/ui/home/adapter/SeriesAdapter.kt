package com.example.marvel_application.ui.home.adapter

import com.example.marvel_application.R
import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.domain.models.Series
import com.example.marvel_application.ui.base.BaseAdapter
import com.example.marvel_application.ui.home.HomeInteractionListener

class SeriesAdapter(items: List<Series>,listener: HomeInteractionListener?) : BaseAdapter<Series>(items,listener) {
    override var layoutId = R.layout.series_item

    override fun areItemSame(oldItem: Series, newItem: Series) = true

}