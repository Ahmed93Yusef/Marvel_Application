package com.example.marvel_application.ui.search

import androidx.fragment.app.viewModels
import com.example.marvel_application.R
import com.example.marvel_application.databinding.FragmentSearchBinding
import com.example.marvel_application.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(){
    override val layoutResId = R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        binding.characterRecycler.adapter = SearchAdapter(emptyList())
    }
}