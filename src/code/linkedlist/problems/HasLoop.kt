package code.linkedlist.problems

import code.linkedlist.LLNode

/**
 * The method should be able to detect if there is a cycle or loop present in the linked list.
 *
 * Uses Floyd's cycle-finding algorithm (also known as the "tortoise and the hare" algorithm) to detect the loop
 *
 * This algorithm uses two pointers: a slow pointer and a fast pointer.
 * The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
 * If there is a loop in the linked list, the two pointers will eventually meet at some point.
 * If there is no loop, the fast pointer will reach the end of the list.
 */
fun hasLoop() {

    val head = LLNode(1)
    head.next = LLNode(2)
    head.next?.next = LLNode(3)
    head.next?.next?.next = LLNode(4)
    head.next?.next?.next?.next = LLNode(5)


    // Create a loop for testing
    head.next?.next?.next?.next?.next = head.next?.next // Loop back to Node 3

    var hasLoop = false

    var slow: LLNode<Int>? = head // tortoise
    var fast: LLNode<Int>? = head // hare

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) {
            hasLoop = true
            break
        }
    }

    if (hasLoop) {
        println("Loop detected in the linked list.")
    } else {
        println("No loop in the linked list.")
    }
}