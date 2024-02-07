package com.example.test_8.di

import com.example.test_8.data.remote.common.ResponseHandler
import com.example.test_8.data.remote.repository.item.ItemRepositoryImpl
import com.example.test_8.data.remote.service.item.ItemApiService
import com.example.test_8.domain.repository.item.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideItemRepository(
        itemApiService: ItemApiService,
        responseHandler: ResponseHandler
    ): ItemRepository {
        return ItemRepositoryImpl(
            itemApiService = itemApiService,
            responseHandler = responseHandler
        )
    }
}