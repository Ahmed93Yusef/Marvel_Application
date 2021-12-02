package com.example.marvel_application.ui.comic

import androidx.fragment.app.viewModels
import com.example.marvel_application.R
import com.example.marvel_application.databinding.FragmentComicBinding
import com.example.marvel_application.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicFragment : BaseFragment<FragmentComicBinding>(){

    override val viewModel: ComicViewModel by viewModels()
    override val layoutResId = R.layout.fragment_comic
}