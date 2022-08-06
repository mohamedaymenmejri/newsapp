package com.aymen.instantnews.data.remote.di

import android.content.Context
import com.aymen.instantnews.data.remote.service.NetworkModuleFactory
import com.aymen.instantnews.data.remote.service.ServiceEndPoint
import dagger.Module
import dagger.Provides

@Module
open class RemoteModule {
    @Provides
    internal open fun provideServiceEndPoint(context: Context): ServiceEndPoint =
        NetworkModuleFactory.makeService(context)
}
