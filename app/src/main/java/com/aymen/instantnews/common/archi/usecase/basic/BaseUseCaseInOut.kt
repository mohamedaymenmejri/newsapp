package com.aymen.instantnews.common.archi.usecase.basic

import com.aymen.instantnews.common.archi.usecase.BaseUseCase

/**
 * Represents the use case behaviour which have input and output.
 */
abstract class BaseUseCaseInOut<in IN, out OUT> : BaseUseCase() {
    abstract fun execute(parameter: IN): OUT
}
