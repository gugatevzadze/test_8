package com.example.test_8.di

import com.example.test_8.domain.repository.item.ItemRepository
import com.example.test_8.domain.usecase.GetItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetItemsUseCase(
        itemRepository: ItemRepository
    ): GetItemUseCase {
        return GetItemUseCase(itemRepository = itemRepository)
    }
}