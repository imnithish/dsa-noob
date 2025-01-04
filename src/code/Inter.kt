package code

data class Order(
    val orderId: String,
    val priority: Int
)

fun countInversions(orders: List<Order>): List<Pair<Order, Order>> {

    val swaps = mutableListOf<Pair<Order, Order>>()

    val ordersSize = orders.size

    for (i in 0..<ordersSize) {
        for (j in i + 1 until orders.size) {
            if (orders[i].priority > orders[j].priority) {
                swaps.add(Pair(orders[i], orders[j]))
            }
        }
    }

    return swaps

}

//fun main() {
////    #23432423	10
////    #34324234	20
////    #21312317	90
////    #12423489	30
////    #34342387	20
////    #13123123	100
////    #12837833      5
////
////    Sample Output
////
////
////            9
////
////    Explanation
////
////    10 -> 1 (10,5)
////    20 -> 1 (20,5)
////    90 -> 3 (90,30) (90,20) (90,5)
////    30 -> 2 (30,20) (30,5)
////    20 -> 1 (20,5)
////    100  -> 1 (100, 5)
//
//    val orders = listOf(
//        Order("23432423", 10),
//        Order("34324234", 20),
//        Order("21312317", 90),
//        Order("12423489", 30),
//        Order("34342387", 20),
//        Order("13123123", 100),
//        Order("12837833", 5),
//    )
//    val foo = countInversions(orders)
//
//    foo.forEach {
//        println(it)
//    }
//
//    println(foo.size)
//}