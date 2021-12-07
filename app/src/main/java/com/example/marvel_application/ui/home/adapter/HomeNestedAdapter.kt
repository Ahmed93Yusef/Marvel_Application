package com.example.marvel_application.ui.home.adapter

import androidx.databinding.library.baseAdapters.BR
import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.ui.base.BaseAdapter
import com.example.marvel_application.ui.home.HomeInteractionListener
import com.example.marvel_application.ui.home.ViewType

class HomeNestedAdapter(
    private var _items: MutableList<List<Any>>,
    private val _listener: HomeInteractionListener?
) : BaseAdapter<Any>(_items, _listener) {
    override val layoutIDs = ViewType.values().map { it.id }

    override fun getItemViewType(position: Int): Int {
        layoutId = layoutIDs[position]
        return super.getItemViewType(position)
    }

    fun setItemsAt(newItems: List<Any>, index: Int) {
        _items[index] = newItems
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val adapter = when (ViewType.values()[position]) {
            ViewType.CHARACTER -> CharacterAdapter(
                _items[position] as List<Characters>,

            )

            ViewType.CHARACTERTWO -> CharacterTopAdapter(
                _items[position] as List<Characters>,

            )
            ViewType.CHARACTERTHREE -> CharacterAdapter(
                _items[position] as List<Characters>,

            )
            ViewType.CHARACTERF -> CharacterAdapter(
                _items[position] as List<Characters>,

            )
        }
        (holder as ItemViewHolder).binding.setVariable(BR.adapter, adapter)
    }

    override fun getItemCount() = layoutIDs.size
    override var layoutId: Int = layoutIDs.first()

    override fun areItemSame(oldItem: Any, newItem: Any) = true
}