package com.aymen.instantnews.data.remote.di

import com.aymen.instantnews.data.remote.datasource.news.NewsRemote
import com.aymen.instantnews.data.remote.datasource.news.NewsRemoteImp
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RemoteContractModule {

    @Binds
    @Singleton
    abstract fun getNewsRemoteImp(newsRemoteImp: NewsRemoteImp): NewsRemote
}
