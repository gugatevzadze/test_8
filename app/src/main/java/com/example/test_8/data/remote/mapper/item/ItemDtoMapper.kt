package com.example.test_8.data.remote.mapper.item

import com.example.test_8.data.remote.model.item.ItemDto
import com.example.test_8.domain.model.Item

fun ItemDto.toDomain(): Item {
    return Item(
        id = id,
        cover = cover,
        price = price,
        title = title,
        location = location,
        reactionCount = reactionCount,
        rate = rate
    )
}