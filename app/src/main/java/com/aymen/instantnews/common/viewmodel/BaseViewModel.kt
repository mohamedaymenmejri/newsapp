package com.aymen.instantnews.common.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import timber.log.Timber

abstract class BaseViewModel :
    LifecycleObserver,
    ViewModel() {

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    init {
        Timber.tag(this.javaClass.simpleName).i("init")
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // LIFE CYCLE
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    @CallSuper
    override fun onCleared() {
        Timber.tag(this.javaClass.simpleName).i("onCleared")
        super.onCleared()
    }
}
