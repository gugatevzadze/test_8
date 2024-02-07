package com.example.test_8.domain.usecase

import com.example.test_8.domain.repository.item.ItemRepository
import javax.inject.Inject

class GetItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke() = itemRepository.getItems()
}