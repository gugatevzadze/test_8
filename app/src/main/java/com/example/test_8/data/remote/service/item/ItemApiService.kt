package com.example.test_8.data.remote.service.item


import com.example.test_8.data.remote.model.item.ItemDto
import retrofit2.Response
import retrofit2.http.GET

interface ItemApiService {
    @GET("0545ddc1-c487-46ce-b70c-5b95270d6b76")
    suspend fun getItemsList(): Response<List<ItemDto>>
}