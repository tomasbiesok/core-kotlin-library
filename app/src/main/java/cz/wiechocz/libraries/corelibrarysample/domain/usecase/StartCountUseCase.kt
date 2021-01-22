package cz.wiechocz.libraries.corelibrarysample.domain.usecase

import cz.wiechocz.libraries.core.result.Result
import cz.wiechocz.libraries.core.usecase.NoParamsResultUseCase
import cz.wiechocz.libraries.corelibrarysample.data.CounterManager

class StartCountUseCase : NoParamsResultUseCase<Unit>() {

    override suspend fun doWork(params: Unit): Result<Unit> {
        return CounterManager.instance.startCount()
    }
}