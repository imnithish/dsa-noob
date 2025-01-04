package code

import kotlinx.coroutines.delay

//fun main(): Unit = runBlocking {
//    supervisorScope {
//        launch {
//            job2()
//        }.invokeOnCompletion { throwable ->
//            if (throwable != null) {
//                println("job2 failed with: ${throwable.message}")
//            }
//        }
//
//        launch {
//            job1()
//        }
//    }
//}

suspend fun job2() {
    println("job2")
    throw RuntimeException("This is a crash test!")
}

suspend fun job1() {
    delay(10000L)
    println("job1")
}