package com.aymen.instantnews.common.archi.usecase.suspend

import com.aymen.instantnews.common.archi.usecase.BaseUseCase

/**
 * Represents the use case behaviour which have input and output.
 */
abstract class BaseSuspendUseCaseInOut<in IN, out OUT> : BaseUseCase() {
    abstract suspend fun execute(parameter: IN): OUT
}
