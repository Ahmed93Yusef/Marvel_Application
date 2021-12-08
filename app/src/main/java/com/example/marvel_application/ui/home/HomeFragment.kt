package com.example.marvel_application.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_application.R
import com.example.marvel_application.databinding.FragmentHomeBinding
import com.example.marvel_application.domain.models.*
import com.example.marvel_application.ui.base.BaseFragment
import com.example.marvel_application.ui.home.adapter.HomeNestedAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(){
    override val viewModel: HomeViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = mutableListOf(
            emptyList<Characters>(),
            emptyList<Comic>(),
            emptyList<Creators>(),
            emptyList<Event>(),
            emptyList<Series>(),
        )
        val adapter = HomeNestedAdapter(items,viewModel)

        viewModel.charactersItems.observe(this,{
            adapter.setItemsAt(it as List<Characters>, HomeItemsType.CHARACTER.index)
        })

        viewModel.comicItems.observe(this,{
            adapter.setItemsAt(it as List<Comic>, HomeItemsType.COMIC.index)
        })
        viewModel.creatorsItems.observe(this,{
            adapter.setItemsAt(it as List<Creators>, HomeItemsType.CREATORS.index)
        })
        viewModel.eventItems.observe(this,{
            adapter.setItemsAt(it as List<Event>, HomeItemsType.EVENT.index)
        })
        viewModel.seriesItems.observe(this,{
            adapter.setItemsAt(it as List<Series>, HomeItemsType.SERIES.index)
        })


        binding.adapter = adapter
    }

    override val layoutResId: Int
        get() = R.layout.fragment_home

}