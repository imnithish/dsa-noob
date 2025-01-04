package code


// Liskov Substitution
open class Rectangle(open var width: Int, open var height: Int) {
    open fun area() = width * height
}

class Square(private val size: Int) : Rectangle(size, size) {
    override var height: Int
        get() = super.height
        set(value) {
            super.height = value
            super.width = value
        }

    override var width: Int
        get() = super.width
        set(value) {
            super.height = value
            super.width = value
        }
}

//fun main() {
//    val rect: Rectangle = Square(5)
//    rect.area()
//
//
//
//    paymentProcessor(UPI(), 4.4)
//
//
//    var length = 0
//    var result = ' '
//
//    for (i in 1..100) {
//        val currentNumber = i.toString()
//        length += currentNumber.length
//
//        if (length >= 55) {
//            val indexInCurrent = 55 - (length - currentNumber.length) - 1
//            result = currentNumber[indexInCurrent]
//            break
//        }
//    }
//
//    println(result)
//}

// Open Closed
interface Payment {
    fun pay(amount: Double)
}

class UPI() : Payment {
    override fun pay(amount: Double) {
        //
    }

}

class Card() : Payment {
    override fun pay(amount: Double) {
        //
    }
}

fun paymentProcessor(payment: Payment, amount: Double) {
    payment.pay(amount)
}


sealed class ResultWrapper<out T> {
    data class Success<out T>(val data: T) : ResultWrapper<T>()
    data object Failure : ResultWrapper<Nothing>()
}

suspend fun <D> safeAPICall(call: suspend () -> D): ResultWrapper<D> {
    return try {

        ResultWrapper.Success(call.invoke())
    } catch (e: Exception) {
        ResultWrapper.Failure
    }

}

class Stack<T>() {
    val stack: MutableList<T> = mutableListOf()
    fun insert(value: T) {
        stack.add(value)
    }
}


interface Foo {
    fun doSomething()
    fun noDoSomething() {
        println("Aww snap!")
    }
}

class Goo() : Foo {
    override fun doSomething() {
        TODO("Not yet implemented")
    }

}

// Dependency Inversion
interface Medicine {
    fun save()
}

class AyurvedicMed : Medicine {
    override fun save() {

    }
}

class EnglishMed : Medicine {
    override fun save() {

    }
}

class LifeSaver(
        private val med: Medicine
) {

    fun foo() {
        med.save()
    }

}


fun DoDo() {
    val lifeSaver = LifeSaver(EnglishMed())
    val lifeSaver2 = LifeSaver(AyurvedicMed())
}