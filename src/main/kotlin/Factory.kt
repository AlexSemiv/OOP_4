import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

object Factory {
    private val mutex = Mutex()
    private var currentTemp = 0L

    suspend fun heating(timeMillis: Long): Long = mutex.withLock {
        println("heating.. ($currentTemp)")
        delay(timeMillis)
        currentTemp += timeMillis
        println("after heating chocolate temp: $currentTemp")
        currentTemp.also {
            println()
        }
    }

    suspend fun cooling(timeMillis: Long): Long = mutex.withLock {
        println("cooling.. ($currentTemp)")
        delay(timeMillis)
        currentTemp -= timeMillis
        println("after cooling chocolate temp: $currentTemp")
        currentTemp.also {
            println()
        }
    }
}