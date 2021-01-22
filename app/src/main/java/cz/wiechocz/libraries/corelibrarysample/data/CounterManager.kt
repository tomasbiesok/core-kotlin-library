package cz.wiechocz.libraries.corelibrarysample.data

import cz.wiechocz.libraries.core.extensions.safeCallUnit
import cz.wiechocz.libraries.core.result.Result
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class CounterManager {

    private constructor()

    private var running: Boolean = false
    private val runningMutex = Mutex()

    private var job: Job? = null

    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter

    suspend fun startCount(): Result<Unit> =
        safeCallUnit {
            toggleRun(true)

            job = GlobalScope.launch {
                while (true) {
                    delay(1000)
                    _counter.value = _counter.value + 1
                }
            }
        }

    suspend fun stopCount() {
        toggleRun(false)
        job?.let {
            if (!it.isCancelled) {
                it.cancel()
            }
        }
    }

    private suspend fun toggleRun(run: Boolean) {
        runningMutex.withLock {
            if (run && running) {
                throw Exception("Counter running!")
            } else {
                running = run
            }
        }
    }

    companion object {

        val instance by lazy { CounterManager() }
    }
}