package com.aymen.instantnews.di.modules

import android.content.Context
import com.aymen.instantnews.data.remote.di.RemoteModule
import com.aymen.instantnews.data.remote.service.ServiceEndPoint
import dagger.Module
import dagger.Provides
import io.mockk.mockk

@Module
class RemoteModuleTest : RemoteModule() {
    @Provides
    fun provideServiceEndPointTest(context: Context): ServiceEndPoint = mockk()
}
