package com.iyaliyul.newssssapp.data.source

import com.iyaliyul.newssssapp.data.model.ResponseNews
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
        ): ResponseNews
}