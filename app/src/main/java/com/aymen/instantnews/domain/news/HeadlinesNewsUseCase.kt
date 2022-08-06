package com.aymen.instantnews.domain.news

import com.aymen.instantnews.common.archi.usecase.suspend.BaseSuspendUseCaseInOut
import com.aymen.instantnews.data.entities.ArticleResponseWrapper
import com.aymen.instantnews.data.entities.Specification
import com.aymen.instantnews.data.repository.news.NewsDataRepository
import javax.inject.Inject

open class HeadlinesNewsUseCase @Inject constructor() :
    BaseSuspendUseCaseInOut<Specification, ArticleResponseWrapper?>() {

    @Inject
    lateinit var newsDataStore: NewsDataRepository

    override suspend fun execute(parameter: Specification): ArticleResponseWrapper? =
        newsDataStore.retrieveNewsAccordingTo(
            category = parameter.category,
            country = parameter.country
        )
}
