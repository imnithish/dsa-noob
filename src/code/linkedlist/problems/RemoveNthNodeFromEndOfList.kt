package code.linkedlist.problems

import code.linkedlist.LLNode

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
fun removeNthFromEnd(n: Int = 2) {

    val head = LLNode(1)
    head.next = LLNode(2)
    head.next?.next = LLNode(3)
    head.next?.next?.next = LLNode(4)
    head.next?.next?.next?.next = LLNode(5)


    // Solution starts here
    val dummy = LLNode(0)
    dummy.next = head

    var slow: LLNode<Int>? = dummy
    var fast: LLNode<Int>? = dummy

    for (i in 0..n) {
        fast = fast?.next
    }

    while (fast != null) {
        slow = slow?.next
        fast = fast.next
    }

    // remove node
    val temp = slow?.next
    slow?.next = temp?.next
    temp?.next = null

    println(dummy.next)
}