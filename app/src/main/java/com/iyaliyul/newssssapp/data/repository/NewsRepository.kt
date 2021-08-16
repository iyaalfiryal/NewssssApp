package com.iyaliyul.newssssapp.data.repository

import com.iyaliyul.newssssapp.data.model.ResponseNews
import com.iyaliyul.newssssapp.data.source.APIService
import com.iyaliyul.newssssapp.utils.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: APIService){
    suspend fun getNews(
        country: String,
        apiKey: String
    ): Flow<Resources<ResponseNews>>{
        return flow {
            val response = apiService.getNews(country, apiKey)
8
            try {
                if (response.articles.isNotEmpty()){
                    emit(Resources.Success(response))
                }else{
                    emit(Resources.Empty)
                }
            }catch (e : HttpException){
                emit(Resources.Error(e.toString(), response))
            }
        }
    }
}