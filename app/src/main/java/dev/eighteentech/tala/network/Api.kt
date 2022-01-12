package dev.eighteentech.tala.network

import dev.eighteentech.tala.entities.Item
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api {
    @Headers("mock:true")
    @GET("/items")
    suspend fun getItems():List<Item>
}