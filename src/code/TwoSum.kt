package code

fun twoSum(numbers: IntArray, target: Int): Pair<Int, Int>? {

    val map = mutableMapOf<Int, Int>()
    for ((i, num) in numbers.withIndex()) {
        val complement = target - num


        if (map.containsKey(complement)) {
            return Pair(map[complement]!!, i)
        }

        map[num] = i

    }

    return null
}