package dev.eighteentech.tala.repository

import dev.eighteentech.tala.entities.Item
import dev.eighteentech.tala.entities.Response
import dev.eighteentech.tala.network.Api
import javax.inject.Inject

class ItemsRepository @Inject constructor(private val api: Api) {

    suspend fun getItems(): Response<List<Item>> {
        return try {
            Response.Success(api.getItems().sortedBy { it.timestamp })
        } catch (e: Exception) {
            Response.Error(e)
        }
    }

}