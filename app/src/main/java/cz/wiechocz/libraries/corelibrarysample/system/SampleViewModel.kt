package cz.wiechocz.libraries.corelibrarysample.system

import androidx.lifecycle.ViewModel
import cz.wiechocz.libraries.corelibrarysample.domain.usecase.GetDelayedNumberUseCase
import cz.wiechocz.libraries.corelibrarysample.domain.usecase.ObserveCounterUseCase
import cz.wiechocz.libraries.corelibrarysample.domain.usecase.StartCountUseCase
import cz.wiechocz.libraries.corelibrarysample.domain.usecase.StopCountUseCase
import kotlinx.coroutines.flow.StateFlow

class SampleViewModel : ViewModel() {

    suspend fun invokeUseCase(input: String): Int? {
        val useCase = GetDelayedNumberUseCase()
        val result = useCase(input)
        return result.data
    }

    suspend fun observeCounter(): StateFlow<Int> {
        val useCase = ObserveCounterUseCase()
        return useCase(Unit)
    }

    suspend fun startCount(): Boolean {
        val useCase = StartCountUseCase()
        val result = useCase(Unit)
        return result.isSuccess()
    }

    suspend fun stopCount() {
        val useCase = StopCountUseCase()
        val result = useCase(Unit)
    }
}