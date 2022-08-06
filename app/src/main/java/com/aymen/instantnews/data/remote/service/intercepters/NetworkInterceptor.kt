package com.aymen.instantnews.data.remote.service.intercepters

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

object NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val cacheControl: CacheControl = CacheControl.Builder()
            .maxAge(1, TimeUnit.HOURS)
            .maxStale(3, TimeUnit.DAYS)
            .build()
        return chain.proceed(chain.request())
            .newBuilder()
            .removeHeader("Pragma")
            .header("Cache-Control", cacheControl.toString())
            .build()
    }
}
