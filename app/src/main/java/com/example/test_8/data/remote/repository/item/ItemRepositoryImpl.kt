package com.example.test_8.data.remote.repository.item

import com.example.test_8.data.remote.common.Resource
import com.example.test_8.data.remote.common.ResponseHandler
import com.example.test_8.data.remote.mapper.base.mapToDomain
import com.example.test_8.data.remote.mapper.item.toDomain
import com.example.test_8.data.remote.service.item.ItemApiService
import com.example.test_8.domain.model.Item
import com.example.test_8.domain.repository.item.ItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val itemApiService: ItemApiService,
    private val responseHandler: ResponseHandler
) : ItemRepository {
    override suspend fun getItems(): Flow<Resource<List<Item>>> {
        return responseHandler.safeApiCall {
            itemApiService.getItemsList()
        }.mapToDomain { itemsDto ->
            itemsDto.map { it.toDomain() }
        }
    }
}