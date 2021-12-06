package com.example.marvel_application.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.marvel_application.BR
import com.example.marvel_application.R
import com.example.marvel_application.databinding.CharacteresItemBinding
import com.example.marvel_application.databinding.ComicItemBinding
import com.example.marvel_application.databinding.EventItemBinding
import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.domain.models.Comic
import com.example.marvel_application.domain.models.Event
import com.example.marvel_application.domain.models.HomeItem
import com.example.marvel_application.domain.models.enumaration.HomeItemType
import com.example.marvel_application.ui.base.BaseAdapter

class HomeAdapter(item: List<HomeItem<Any>>, listener: HomeInteractionListener?) :
    BaseAdapter<HomeItem<Any>>(
        items = item,
        listener = listener,
        layoutId = R.layout.characteres_item
    ) {
    override fun areItemSame(oldItem: HomeItem<Any>?, newItem: HomeItem<Any>?) = true

    private lateinit var binding: ViewDataBinding

    class CharacterViewHolder(itemView: ViewDataBinding) : BaseViewHolder(itemView) {
        val binding = CharacteresItemBinding.bind(itemView.root)
    }

    class ComicViewHolder(itemView: ViewDataBinding) : BaseViewHolder(itemView) {
        val binding = ComicItemBinding.bind(itemView.root)
    }

    class EventViewHolder(itemView: ViewDataBinding) : BaseViewHolder(itemView) {
        val binding = EventItemBinding.bind(itemView.root)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val current = getItems()[position]
        when (holder) {
            is CharacterViewHolder -> {
                val adapter = CharacterAdapter<Characters>(emptyList(), null)
                holder.binding.apply {
                    setVariable(BR.items, current.item as HomeItem<Characters>)
                    recycleView.adapter = adapter
                }
            }
            is ComicViewHolder -> {
                val adapter = CharacterAdapter<Comic>(emptyList(), null)
                holder.binding.apply {
                    setVariable(BR.items, current.item as HomeItem<Comic>)
                    recycleView.adapter = adapter
                }
            }
            is EventViewHolder -> {
                val adapter = CharacterAdapter<Event>(emptyList(), null)
                holder.binding.apply {
                    setVariable(BR.items, current.item as HomeItem<Event>)
                    recycleView.adapter = adapter
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_CHARACTERS -> {
                binding = DataBindingUtil.inflate(layoutInflater,
                    R.layout.characteres_item,
                    parent,
                    false)
                CharacterViewHolder(binding)
            }
            VIEW_TYPE_COMIC -> {
                binding = DataBindingUtil.inflate(layoutInflater,
                    R.layout.comic_item,
                    parent,
                    false)
                CharacterViewHolder(binding)
            }
            VIEW_TYPE_Event -> {
                binding = DataBindingUtil.inflate(layoutInflater,
                    R.layout.event_item,
                    parent,
                    false)
                CharacterViewHolder(binding)
            }
            else -> throw Exception("UNKNOWN VIEW TYPE")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItems()[position].itemType) {
            HomeItemType.CHARACTERS_ITEMS -> VIEW_TYPE_CHARACTERS
            HomeItemType.COMIC_ITEMS -> VIEW_TYPE_COMIC
            HomeItemType.EVENT_ITEMS -> VIEW_TYPE_Event
            else -> throw Exception("UNKNOWN VIEW TYPE")
        }
    }

    companion object {
        private const val VIEW_TYPE_COMIC = 1
        private const val VIEW_TYPE_CHARACTERS = 2
        private const val VIEW_TYPE_Event = 3
    }
}