package com.aymen.instantnews.common.utils

fun Long.getElapsedTime(): String {
    var timeElapsedInSeconds = (System.currentTimeMillis() - this) / 1000
    return if (timeElapsedInSeconds < 60) {
        "less than 1m"
    } else if (timeElapsedInSeconds < 3600) {
        timeElapsedInSeconds /= 60
        timeElapsedInSeconds.toString() + "m"
    } else if (timeElapsedInSeconds < 86400) {
        timeElapsedInSeconds /= 3600
        timeElapsedInSeconds.toString() + "h"
    } else {
        timeElapsedInSeconds /= 86400
        timeElapsedInSeconds.toString() + "d"
    }
}
