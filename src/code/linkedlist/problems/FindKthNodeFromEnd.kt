package code.linkedlist.problems

import code.linkedlist.LLNode

/**
 * Finds the k-th node from the end of the Linked List.
 *
 * This code is kind of like a game of tag, where you and your friend are running along a straight line of stones (these stones are like the "nodes" of our linked list). You're "slow" and your friend is "fast".
 * The rule of the game is your friend gets a head start and runs "k" stones ahead first.
 * If your friend runs out of stones before counting to "k" (when fast equals null), then you know the line of stones is not long enough (return null).
 * But if there are enough stones, after your friend's head start, you both start running together. If your friend hits the end of the line (when fast equals null again), the stone you are standing on is "k" stones from the end.
 * And that's the stone this code is trying to find!
 */
fun findKthNodeFromEnd(k: Int = 4) {
    val head = LLNode(1)
    head.next = LLNode(2)
    head.next?.next = LLNode(3)
    head.next?.next?.next = LLNode(4)
    head.next?.next?.next?.next = LLNode(5)


    var slow: LLNode<Int>? = head
    var fast: LLNode<Int>? = head

    for (i in 1..k) {
        if (fast == null) {
            println("List has fewer than k nodes")
            return
        }
        fast = fast.next
    }

    while (fast != null) {
        slow = slow?.next
        fast = fast.next
    }

    println("$k Node from the end is ${slow?.value}")

}