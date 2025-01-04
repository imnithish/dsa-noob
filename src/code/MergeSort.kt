package code


class MergeSort {

    private var inversionCount = 0

    private fun merge(list1: IntArray, list2: IntArray): IntArray {

        val finalList = IntArray(list1.size + list2.size)

        var index = 0 // index of combined array
        var i = 0 // index of list1
        var j = 0 // list2

        while (i < list1.size && j < list2.size) {
            if (list1[i] <= list2[j]) {
                finalList[index] = list1[i]
                index++
                i++
            } else {
                finalList[index] = list2[j]
                index++
                j++

                inversionCount += (list1.size - i)
            }
        }

        while (i < list1.size) {
            finalList[index] = list1[i]
            index++
            i++
        }

        while (j < list2.size) {
            finalList[index] = list2[j]
            index++
            j++
        }


        return finalList

    }

    fun mergeSort(list: IntArray): IntArray {

        if (list.size <= 1) return list

        val midIndex = list.size / 2

        val left: IntArray = mergeSort(list.slice(0 until midIndex).toIntArray())
        val right = mergeSort(list.slice(midIndex until list.size).toIntArray())

        return merge(left, right)
    }

    fun countInversions(list: IntArray): Int {
        inversionCount = 0 // Reset counter for new input
        mergeSort(list)
        return inversionCount
    }
}

//fun main() {
//  val foo=  MergeSort().mergeSort(intArrayOf(10, 20, 90, 30, 20, 100, 5))
//
//    foo.forEach {
//        println(it)
//
//    }
//}