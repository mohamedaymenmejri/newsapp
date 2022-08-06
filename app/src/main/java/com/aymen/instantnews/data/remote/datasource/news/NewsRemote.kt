package com.aymen.instantnews.data.remote.datasource.news

import com.aymen.instantnews.data.entities.ArticleResponseWrapper

interface NewsRemote {
    suspend fun retrieveNewsAccordingTo(
        category: String?,
        country: String?
    ): ArticleResponseWrapper?
}
