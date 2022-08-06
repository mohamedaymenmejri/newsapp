package com.aymen.instantnews.data.remote.service

import android.content.Context
import com.aymen.instantnews.BuildConfig
import com.aymen.instantnews.common.utils.DateDeserializer
import com.aymen.instantnews.data.remote.service.intercepters.NetworkInterceptor
import com.aymen.instantnews.data.remote.service.intercepters.RequestInterceptor
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.inject.Named

open class BaseNetworkModuleFactory {
    companion object {
        val CONNECT_TIMEOUT by lazy {
            500L // 10MB
        }
        val READ_TIMEOUT by lazy {
            500L // 10MB
        }
        val SUCCESS_RESPONSE_CODE by lazy {
            200
        }
    }

    fun makeOkHttpClient(context: Context): OkHttpClient {
        // 5 MB of cache
        val cache = Cache(context.applicationContext.cacheDir, 5 * 1024 * 1024)

        // Used for cache connection
        val networkInterceptor = NetworkInterceptor

        return OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .cache(cache)
            .addNetworkInterceptor(networkInterceptor)
            .addInterceptor(provideLogInterceptor())
            .addInterceptor(provideRequestInterceptor())
            .build()
    }

    @Named(NetworkModuleFactory.LOG_INTERCEPTOR)
    internal fun provideLogInterceptor(): Interceptor {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return logInterceptor
    }

    @Named(NetworkModuleFactory.REQUEST_INTERCEPTOR)
    internal fun provideRequestInterceptor(): Interceptor = RequestInterceptor()

    ///////////////////////////////////////////////////////////////////////////
    // RETROFIT BUILDER
    ///////////////////////////////////////////////////////////////////////////
    fun buildRetrofitObject(
        okHttpClient: OkHttpClient
    ): Retrofit {
        val gson = GsonBuilder()
            .registerTypeAdapter(Date::class.java, DateDeserializer())
            .create()
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASEURL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .build()
    }
}
