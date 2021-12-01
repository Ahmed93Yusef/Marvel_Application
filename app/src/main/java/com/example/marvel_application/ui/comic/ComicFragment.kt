package com.example.marvel_application.ui.comic

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.marvel_application.R
import com.example.marvel_application.databinding.FragmentComicBinding
import com.example.marvel_application.ui.base.BaseFragment
import com.example.marvel_application.util.Constant.TAG


class ComicFragment : BaseFragment<FragmentComicBinding>(){
    override val layoutResId = R.layout.fragment_comic
    override val viewModel: ComicViewModel by viewModels()

    private val args: ComicFragmentArgs by navArgs()

    override fun onStart() {
        super.onStart()
        viewModel.id = args.id
        Log.i(TAG, "onStart: ${args.id}")
    }
}