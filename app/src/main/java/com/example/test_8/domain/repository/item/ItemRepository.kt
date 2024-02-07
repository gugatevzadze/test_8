package com.example.test_8.domain.repository.item

import com.example.test_8.data.remote.common.Resource
import com.example.test_8.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    suspend fun getItems(): Flow<Resource<List<Item>>>
}