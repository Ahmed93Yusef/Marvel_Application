package com.example.marvel_application.ui.home

import androidx.fragment.app.viewModels
import com.example.marvel_application.R
import com.example.marvel_application.databinding.FragmentHomeBinding
import com.example.marvel_application.domain.models.*
import com.example.marvel_application.ui.base.BaseFragment
import com.example.marvel_application.ui.home.adapter.HomeNestedAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(), HomeInteractionListener {
    override val viewModel: HomeViewModel by viewModels()

    override fun onResume() {
        super.onResume()
        setAdapter()
    }

    private fun setAdapter(){
        val items = mutableListOf(
            emptyList<Characters>(),
            emptyList<Comic>(),
            emptyList<Creators>(),
            emptyList<Event>(),
            emptyList<Series>(),
//            emptyList<Search>()
        )
        val adapter = HomeNestedAdapter(items,this)

        viewModel.charactersItems.observe(this,{ value ->
            adapter.setItemsAt(value as List<Characters>, HomeItemsType.CHARACTER.index)
        })
        viewModel.comicItems.observe(this,{value ->
            adapter.setItemsAt(value as List<Comic>, HomeItemsType.COMIC.index)
        })
        viewModel.creatorsItems.observe(this,{value ->
            adapter.setItemsAt(value as List<Creators>, HomeItemsType.CREATORS.index)
        })
        viewModel.eventItems.observe(this,{value ->
            adapter.setItemsAt(value as List<Event>, HomeItemsType.EVENT.index)
        })
        viewModel.seriesItems.observe(this,{value ->
            adapter.setItemsAt(value as List<Series>, HomeItemsType.SERIES.index)
        })
//        viewModel.resentSearch.observe(this,{value ->
//            adapter.setItemsAt(value as List<Search>, HomeItemsType.SEARCH.index)
//        })

        binding.adapter = adapter
    }

    override val layoutResId: Int
        get() = R.layout.fragment_home

    override fun onItemClicked(id: Long) {
        viewModel.navigate(HomeFragmentDirections.actionHomeFragmentToComicFragment(id))
    }

    override fun onSearchIconClicked(itemType: String) {
        viewModel.navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment(itemType))
    }
}