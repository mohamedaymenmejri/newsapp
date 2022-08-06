package com.aymen.instantnews.data.remote.service

import com.aymen.instantnews.data.entities.ArticleResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceEndPoint {

    @GET("/v2/top-headlines")
    suspend fun getHeadlines(
        @Query("category") category: String?,
        @Query("country") country: String?
    ): ArticleResponseWrapper?
}
