package com.aymen.instantnews.data.repository.di

import com.aymen.instantnews.data.repository.news.NewsDataRepository
import com.aymen.instantnews.data.repository.news.NewsDataStoreRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryContractModule {
    @Binds
    @Singleton
    abstract fun getNewsDataStoreRepository(
        newsDataStoreRepository: NewsDataStoreRepository
    ): NewsDataRepository
}
