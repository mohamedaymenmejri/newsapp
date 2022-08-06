package com.aymen.instantnews.data.repository.news

import com.aymen.instantnews.data.entities.ArticleResponseWrapper

interface NewsDataRepository {
    suspend fun retrieveNewsAccordingTo(
        category: String?,
        country: String?
    ): ArticleResponseWrapper?
}
