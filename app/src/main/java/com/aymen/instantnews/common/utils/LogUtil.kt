@file:Suppress("NOTHING_TO_INLINE")

package com.aymen.instantnews.common.utils

import com.aymen.instantnews.common.archi.usecase.BaseUseCase
import timber.log.Timber

object LogUtil {
    inline fun d(context: Any, msg: String) {
        Timber.tag("$context == Mobile Payment").d(msg)
    }

    inline fun d(msg: String) {
        Timber.d(msg)
    }

    inline fun i(context: Any, msg: String) {
        Timber.tag("$context == Mobile Payment").i(msg)
    }

    inline fun i(tag: String, msg: String) {
        Timber.tag("$tag == Mobile Payment").i(msg)
    }

    fun iuc(useCase: BaseUseCase, parameter: Any?) {
        Timber.tag("$useCase == Mobile Payment").i("execution with $parameter")
    }

    fun e(context: Any, msg: String) {
        Timber.tag("$context == Mobile Payment").e(msg)
    }

    fun e(msg: String) {
        Timber.tag("Mobile Payment").e(msg)
    }
}
