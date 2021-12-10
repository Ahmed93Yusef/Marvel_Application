package com.example.marvel_application.ui.home.adapter

import androidx.databinding.library.baseAdapters.BR
import com.example.marvel_application.domain.models.*
import com.example.marvel_application.ui.base.BaseAdapter
import com.example.marvel_application.ui.home.HomeInteractionListener
import com.example.marvel_application.ui.home.HomeItemsType

class HomeNestedAdapter(
    private var _items: MutableList<List<Any>>,
    private val _listener: HomeInteractionListener?
) : BaseAdapter<Any>(_items, _listener) {

    override val layoutIDs = HomeItemsType.values().map { it.id }

    override var layoutId: Int = layoutIDs.first()

    override fun getItemViewType(position: Int): Int {
        layoutId = layoutIDs[position]
        return super.getItemViewType(position)
    }

    fun setItemsAt(newItems: List<Any>, index: Int) {
        _items[index] = newItems
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val adapter = when (HomeItemsType.values()[position]) {
            HomeItemsType.CHARACTER -> CharacterAdapter(
                _items[position] as List<Characters>,
                _listener
            )
            HomeItemsType.COMIC -> ComicAdapter(
                _items[position] as List<Comic>,
                _listener
            )
            HomeItemsType.CREATORS -> CreatorsAdapter(
                _items[position] as List<Creators>,
                _listener
            )
            HomeItemsType.EVENT -> EventAdapter(
                _items[position] as List<Event>,
                _listener
            )
            HomeItemsType.SERIES -> SeriesAdapter(
                _items[position] as List<Series>,
                _listener
            )
//            HomeItemsType.SEARCH -> ResentSearchAdapter(
//                _items[position] as List<Search>,
//                _listener
//            )
        }
        (holder as ItemViewHolder).binding.setVariable(BR.adapter, adapter)
    }

    override fun getItemCount() = layoutIDs.size

    override fun areItemSame(oldItem: Any, newItem: Any) = true
}