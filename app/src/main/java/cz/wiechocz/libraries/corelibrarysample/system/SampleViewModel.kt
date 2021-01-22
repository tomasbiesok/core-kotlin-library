package cz.wiechocz.libraries.corelibrarysample.system

import androidx.lifecycle.ViewModel
import cz.wiechocz.libraries.corelibrarysample.domain.usecase.GetDelayedNumberUseCase

class SampleViewModel : ViewModel() {

    suspend fun invokeUseCase(input: String): Int? {
        val useCase = GetDelayedNumberUseCase()
        val result = useCase(input)
        return result.data
    }
}