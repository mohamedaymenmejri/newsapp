package com.aymen.instantnews.data.repository.news

import com.aymen.instantnews.data.entities.ArticleResponseWrapper
import com.aymen.instantnews.data.remote.datasource.news.NewsRemote
import javax.inject.Inject

class NewsDataStoreRepository @Inject constructor() : NewsDataRepository {

    @Inject
    lateinit var newsRemote: NewsRemote

    override suspend fun retrieveNewsAccordingTo(
        category: String?,
        country: String?
    ): ArticleResponseWrapper? = newsRemote.retrieveNewsAccordingTo(category, country)
}
