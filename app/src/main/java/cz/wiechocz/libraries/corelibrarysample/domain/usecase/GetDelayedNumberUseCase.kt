package cz.wiechocz.libraries.corelibrarysample.domain.usecase

import cz.wiechocz.libraries.core.extensions.safeCall
import cz.wiechocz.libraries.core.result.Result
import cz.wiechocz.libraries.core.usecase.ResultUseCase
import kotlinx.coroutines.delay

class GetDelayedNumberUseCase : ResultUseCase<Any, Int>() {

    override suspend fun doWork(params: Any): Result<Int> =
        safeCall {
            val numberValue = params.toString().toIntOrNull() ?: throw Exception("Param is not Int")
            delay(timeMillis = 1000)
            Result.Success(numberValue)
        }
}