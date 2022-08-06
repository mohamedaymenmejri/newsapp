package com.aymen.instantnews.data.remote.service

import android.content.Context
import okhttp3.OkHttpClient

object NetworkModuleFactory : BaseNetworkModuleFactory() {

    const val LOG_INTERCEPTOR = "LogInterceptor"
    const val REQUEST_INTERCEPTOR = "RequestInterceptor"

    fun makeService(context: Context): ServiceEndPoint = makeService(makeOkHttpClient(context))

    private fun makeService(okHttpClient: OkHttpClient): ServiceEndPoint {
        val retrofit = buildRetrofitObject(okHttpClient)
        return retrofit.create(ServiceEndPoint::class.java)
    }
}
