package com.aymen.instantnews.common.archi.usecase.basic

import com.aymen.instantnews.common.archi.usecase.BaseUseCase

/**
 * Represents the use case behaviour which only get to return data without input.
 */
abstract class BaseUseCaseOut<out OUT> : BaseUseCase() {
    abstract fun execute(): OUT
}
