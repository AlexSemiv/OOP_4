import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking<Unit> {
    repeat(5) { iteration ->
        async { Factory.heating(iteration * 500L) }
        async { Factory.cooling(iteration * 250L) }
    }
}