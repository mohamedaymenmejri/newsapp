package com.aymen.instantnews.common.archi.usecase.suspend

import com.aymen.instantnews.common.archi.usecase.BaseUseCase

/**
 * Represents the use case behaviour which only get to have and input without output.
 */
abstract class BaseSuspendUseCaseIn<in IN> : BaseUseCase() {
    abstract suspend fun execute(input: IN)
}
