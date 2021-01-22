package cz.wiechocz.libraries.corelibrarysample.domain.usecase

import cz.wiechocz.libraries.core.usecase.NoParamsUseCase
import cz.wiechocz.libraries.corelibrarysample.data.CounterManager
import kotlinx.coroutines.flow.StateFlow

class ObserveCounterUseCase : NoParamsUseCase<StateFlow<Int>>() {

    override suspend fun doWork(params: Unit): StateFlow<Int> {
        return CounterManager.instance.counter
    }
}