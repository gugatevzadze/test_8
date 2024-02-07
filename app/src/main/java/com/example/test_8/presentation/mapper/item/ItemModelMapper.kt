package com.example.test_8.presentation.mapper.item

import com.example.test_8.domain.model.Item
import com.example.test_8.presentation.model.item.ItemModel

fun Item.toPresentation(): ItemModel {
    return ItemModel(
        id = id,
        cover = cover,
        price = price,
        title = title,
        location = location,
        reactionCount = reactionCount,
        rate = rate
    )
}