package com.example.marvel_application.ui.home

import com.example.marvel_application.R
import com.example.marvel_application.databinding.FragmentHomeBinding
import com.example.marvel_application.ui.base.BaseFragment
import com.example.marvel_application.util.OnClickListener

class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home),
    OnClickListener {

    override fun getViewModel() = HomeViewModel::class.java

    override fun onClickItem(id: Int) {
    }
}
