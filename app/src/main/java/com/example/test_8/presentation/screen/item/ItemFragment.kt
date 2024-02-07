package com.example.test_8.presentation.screen.item

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewpager2.widget.ViewPager2
import com.example.test_8.databinding.FragmentItemBinding
import com.example.test_8.presentation.adapters.item.ViewPagerAdapter
import com.example.test_8.presentation.base.BaseFragment
import com.example.test_8.presentation.event.item.ItemEvents
import com.example.test_8.presentation.state.item.ItemState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ItemFragment : BaseFragment<FragmentItemBinding>(FragmentItemBinding::inflate) {

    private val viewModel: ItemViewModel by viewModels()

    override fun setUp() {
        setUpAdapter()
    }

    override fun bindObservers() {
        observeItemState()
    }

    private fun setUpAdapter() {
        val adapter = ViewPagerAdapter()
        binding.pager.adapter = adapter
        viewModel.onEvent(ItemEvents.GetItems)
    }

    private fun observeItemState(){
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.itemState.collect {
                    handleItemState(it)
                }
            }
        }
    }

    private fun handleItemState(state: ItemState) {
        state.items?.let {
            (binding.pager.adapter as? ViewPagerAdapter)?.submitList(it)
        }
        state.errorMessage?.let {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            viewModel.onEvent(ItemEvents.UpdateErrorMessages)
        }
        binding.progressBar.isVisible = state.isLoading
    }
}
