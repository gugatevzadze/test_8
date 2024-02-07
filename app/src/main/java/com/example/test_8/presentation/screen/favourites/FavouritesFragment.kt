package com.example.test_8.presentation.screen.favourites

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test_8.R
import com.example.test_8.databinding.FragmentFavouritesBinding
import com.example.test_8.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouritesFragment : BaseFragment<FragmentFavouritesBinding>(FragmentFavouritesBinding::inflate) {
    override fun setUp() {
    }

    override fun bindObservers() {
    }

}