package com.android.coffeshopapp.ui.menu

import retrofit2.Response
import retrofit2.http.GET

interface MenuService {
    @GET("menuItems")
    suspend fun getMenuItems(): List<Response<Product>>
}

data class Product(
    val imageUrl: String,
    val title: String,
    val description: String
)