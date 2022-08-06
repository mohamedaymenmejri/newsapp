package com.aymen.instantnews.data.remote.datasource.news

import com.aymen.instantnews.data.entities.ArticleResponseWrapper
import com.aymen.instantnews.data.remote.service.ServiceEndPoint
import javax.inject.Inject

class NewsRemoteImp @Inject constructor() : NewsRemote {

    @Inject
    lateinit var serviceEndPoint: ServiceEndPoint

    override suspend fun retrieveNewsAccordingTo(
        category: String?,
        country: String?
    ): ArticleResponseWrapper? = serviceEndPoint.getHeadlines(category, country)
}
