package com.example.marvel_application.ui.home

import androidx.fragment.app.viewModels
import com.example.marvel_application.R
import com.example.marvel_application.databinding.FragmentHomeBinding
import com.example.marvel_application.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() , HomeInteractionListener{

    override val viewModel: HomeViewModel by viewModels()

    override val layoutResId = R.layout.fragment_home

    override fun onStart() {
        super.onStart()
        val adapter = HomeAdapter(emptyList(), this)
        binding.recycleView.adapter = adapter
    }

    override fun onClickItem(id: Long) {
        viewModel.navigate(HomeFragmentDirections.actionHomeFragmentToComicFragment(id))
    }
}
