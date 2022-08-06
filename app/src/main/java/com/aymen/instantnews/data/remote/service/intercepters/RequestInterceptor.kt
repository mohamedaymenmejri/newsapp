package com.aymen.instantnews.data.remote.service.intercepters

import android.annotation.SuppressLint
import com.aymen.instantnews.BuildConfig
import okhttp3.Headers
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class RequestInterceptor internal constructor() : Interceptor {

    @SuppressLint("LogConditional")
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val headers = provideHeaders()
        val httpUrl = provideHttpUrl(request)
        val newRequest = provideRequest(request, headers, httpUrl)
        return chain.proceed(newRequest)
    }

    companion object {
        /* Headers */
        private const val AUTHORIZATION = "Authorization"

        private fun provideRequest(original: Request, headers: Headers, httpUrl: HttpUrl): Request {
            val requestBuilder = original.newBuilder()
                .headers(headers)
                .url(httpUrl)
                .method(original.method, original.body)
            return requestBuilder.build()
        }

        /**
         * Provide headers with token as authorisation
         *
         * @param token the token
         * @return the headers
         */
        fun provideHeaders(): Headers {
            val headersBuilder = Headers.Builder()
            headersBuilder.add(AUTHORIZATION, BuildConfig.API_KEY)
            return headersBuilder.build()
        }

        private fun provideHttpUrl(original: Request): HttpUrl {
            val httpUrlBuilder = original.url.newBuilder()
            return httpUrlBuilder.build()
        }
    }
}
