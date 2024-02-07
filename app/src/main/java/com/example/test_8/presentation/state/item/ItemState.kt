package com.example.test_8.presentation.state.item

import com.example.test_8.presentation.model.item.ItemModel

data class ItemState(
    val items: List<ItemModel>? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean = false,
)