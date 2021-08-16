package com.iyaliyul.newssssapp.data.model

data class ResponseNews(
    val articles: List<ArticleItem>,
    val status: String,
    val totalResults: Int
)