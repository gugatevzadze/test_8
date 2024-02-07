package com.example.test_8.presentation.adapters.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test_8.databinding.ViewpagerItemBinding
import com.example.test_8.presentation.model.item.ItemModel

class ViewPagerAdapter :
    ListAdapter<ItemModel, ViewPagerAdapter.ItemViewHolder>(ItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ViewpagerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
    }

    inner class ItemViewHolder(private val binding: ViewpagerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var item: ItemModel
        fun bind() {
            item = currentList[adapterPosition]
            binding.apply {
                Glide.with(ivBackground.context)
                    .load(item.cover)
                    .into(ivBackground)
                tvReactionCount.text = item.reactionCount.toString()
                tvLocation.text = item.location
                tvTitle.text = item.title
                tvPrice.text = item.price
                ratingBar.rating = item.rate?.toFloat() ?: 0f

            }
        }
    }

    private class ItemDiffCallback : DiffUtil.ItemCallback<ItemModel>() {
        override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean {
            return oldItem == newItem
        }
    }
}