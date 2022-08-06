package com.aymen.instantnews.feature.news.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aymen.instantnews.common.archi.resources.Resource
import com.aymen.instantnews.common.archi.resources.ResourceState
import com.aymen.instantnews.common.viewmodel.BaseViewModel
import com.aymen.instantnews.data.entities.Article
import com.aymen.instantnews.data.entities.Specification
import com.aymen.instantnews.domain.news.HeadlinesNewsUseCase
import kotlinx.coroutines.*
import javax.inject.Inject

open class MainViewModel @Inject constructor() : BaseViewModel() {
    ///////////////////////////////////////////////////////////////////////////
    // DEPENDENCY INJECTION
    ///////////////////////////////////////////////////////////////////////////
    @Inject
    lateinit var headlinesNewsUseCase: HeadlinesNewsUseCase

    ///////////////////////////////////////////////////////////////////////////
    // OBSERVERS
    ///////////////////////////////////////////////////////////////////////////
    val newsLiveData = MutableLiveData<Resource<List<Article>?>?>()
    fun observeNewsLiveData(): LiveData<Resource<List<Article>?>?> = newsLiveData

    ///////////////////////////////////////////////////////////////////////////
    // EXECUTES SECTION
    ///////////////////////////////////////////////////////////////////////////
    fun getHeadlinesNews(specification: Specification) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
            val res = Resource(
                ResourceState.ERROR,
                null,
                null
            )
            newsLiveData.postValue(res)
        }

        CoroutineScope(Dispatchers.IO).launch(coroutineExceptionHandler) {
            try {
                val userAsync = async { headlinesNewsUseCase.execute(specification) }
                val user = userAsync.await()

                newsLiveData.postValue(
                    Resource(
                        ResourceState.SUCCESS,
                        user?.articles,
                        //user?.articles,
                        null
                    )
                )
            } catch (e: Exception) {
                val res = Resource(
                    ResourceState.ERROR,
                    null,
                    e.message
                )
                newsLiveData.postValue(res)
            }
        }
    }
}
