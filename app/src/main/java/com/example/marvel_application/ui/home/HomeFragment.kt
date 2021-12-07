package com.example.marvel_application.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.marvel_application.R
import com.example.marvel_application.databinding.FragmentHomeBinding
import com.example.marvel_application.domain.models.Characters
import com.example.marvel_application.ui.base.BaseFragment
import com.example.marvel_application.ui.home.adapter.HomeNestedAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = mutableListOf(
            emptyList<Characters>(),
            emptyList<List<Characters>>(),
            emptyList<Characters>(),
            emptyList<Characters>()
        )
        val adapter = HomeNestedAdapter(items,null)

        viewModel.homeItems.observe(this,{
            adapter.setItemsAt(it as List<Characters>, ViewType.CHARACTER.index)
        })

        viewModel.homeItems.observe(this,{
            adapter.setItemsAt(it as List<Characters>, ViewType.CHARACTERTWO.index)
        })
        viewModel.homeItems.observe(this,{
            adapter.setItemsAt(it as List<Characters>, ViewType.CHARACTERTHREE.index)
        })
        viewModel.homeItems.observe(this,{
            adapter.setItemsAt(it as List<Characters>, ViewType.CHARACTERF.index)
        })


        binding.adapter = adapter
    }

    override val layoutResId: Int
        get() = R.layout.fragment_home

}