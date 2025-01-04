package code.linkedlist.problems

import code.linkedlist.LL

fun linkedListMiddleNode() {
    val myList: LL<Int> = LL(1)
    myList.append(2)
    myList.append(3)
    println("Center node is ${myList.middle()?.value}")

    /**
     * Time Complexity
     * O(n):
     * Both the slow and fast pointers traverse the linked list. The fast pointer moves at twice the speed of the slow pointer, so the total number of steps taken by both together is proportional to the length of the linked list (n).
     * Space Complexity
     * O(1):
     * The algorithm uses only two pointers (slow and fast), which require a constant amount of space irrespective of the size of the linked list.
     * Key Points
     * This approach is efficient as it requires only a single traversal of the linked list.
     * No additional data structures are used, making it optimal in terms of space.
     */
}