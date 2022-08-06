package com.aymen.instantnews.di.modules

import com.aymen.instantnews.common.utils.DateDeserializer
import com.aymen.instantnews.data.remote.di.RemoteModule
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.Executors

@Module
class RemoteModuleTest : RemoteModule() {

}
