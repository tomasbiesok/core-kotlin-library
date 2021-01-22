package cz.wiechocz.libraries.corelibrarysample.domain.usecase

import cz.wiechocz.libraries.core.usecase.NoParamsUseCase
import cz.wiechocz.libraries.corelibrarysample.data.CounterManager

class StopCountUseCase : NoParamsUseCase<Unit>() {

    override suspend fun doWork(params: Unit) {
        CounterManager.instance.stopCount()
    }
}