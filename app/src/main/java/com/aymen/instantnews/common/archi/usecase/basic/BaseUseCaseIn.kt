package com.aymen.instantnews.common.archi.usecase.basic

import com.aymen.instantnews.common.archi.usecase.BaseUseCase

/**
 * Represents the use case behaviour which only get to have and input without output.
 */
abstract class BaseUseCaseIn<in IN> : BaseUseCase() {
    abstract fun execute(input: IN)
}
