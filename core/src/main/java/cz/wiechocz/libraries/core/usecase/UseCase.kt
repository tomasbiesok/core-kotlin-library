package cz.wiechocz.libraries.core.usecase

/**
 * Base class for use cases
 */
abstract class UseCase<IN, OUT>() {

    suspend operator fun invoke(params: IN): OUT = doWork(params)

    abstract suspend fun doWork(params: IN): OUT
}