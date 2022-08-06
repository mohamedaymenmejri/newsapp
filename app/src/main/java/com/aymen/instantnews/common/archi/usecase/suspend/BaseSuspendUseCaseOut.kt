package com.aymen.instantnews.common.archi.usecase.suspend

import com.aymen.instantnews.common.archi.usecase.BaseUseCase

/**
 * Represents the use case behaviour which only get to return data without input.
 */
abstract class BaseSuspendUseCaseOut<out OUT> : BaseUseCase() {
    abstract suspend fun execute(): OUT
}
