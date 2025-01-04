package code.linkedlist

data class LLNode<T>(
    var value: T,
    var next: LLNode<T>? = null
)


class LL<T>(value: T) {

    private var head: LLNode<T>?
    private var tail: LLNode<T>?
    private var length = 0

    init {
        val newNode = LLNode(value)
        head = newNode
        tail = newNode
        length++
    }


    fun printList() {
        var currNode = head
        while (currNode != null) {
            println(currNode.value)
            currNode = currNode.next
        }
    }

    fun append(value: T) {
        val newNode = LLNode(value)

        if (length == 0) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = newNode
        }

        length++

    }

    fun removeLast(): LLNode<T>? {
        if (length == 0) return null else {

            var temp: LLNode<T>? = head
            var pre: LLNode<T>? = null

            while (temp?.next != null) {
                pre = temp
                temp = temp.next
            }

            pre?.next = null
            tail = pre
            length--
            if (length == 0) {
                head = null
                tail = null
            }
            return temp
        }
    }


    fun prepend(value: T) {
        val newNode = LLNode(value)
        if (length == 0) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head = newNode
        }
        length++
    }

    fun removeFirst(): LLNode<T>? {
        if (length == 0) return null else {
            val temp = head
            head = temp?.next
            temp?.next = null
            length--
            if (length == 0)
                tail = null
            return temp
        }
    }


    fun get(index: Int): LLNode<T>? {
        if (index < 0 || index >= length) {
            return null
        } else {
            var temp = head

            repeat(index) {
                temp = temp?.next
            }

            return temp
        }
    }

    fun set(value: T, index: Int): Boolean {
        val node = get(index)
        if (node != null) {
            node.value = value
            return true
        }
        return false
    }

    fun insert(value: T, index: Int): Boolean {
        if (index < 0 || index > length) {
            return false
        } else {
            when (index) {
                0 -> prepend(value)
                length -> append(value)
                else -> {
                    val newNode = LLNode(value)

                    val preNode = get(index - 1)

                    newNode.next = preNode?.next
                    preNode?.next = newNode
                    length++
                    return true

                }
            }

            return true
        }
    }


    fun remove(index: Int): LLNode<T>? {
        if (index < 0 || index >= length) {
            return null
        } else {

            when (index) {
                0 -> return removeFirst()
                length - 1 -> return removeLast()
                else -> {
                    val preNode = get(index - 1)

                    val temp = preNode?.next

                    preNode?.next = temp?.next

                    temp?.next = null
                    length--
                    return temp
                }
            }

        }
    }

    fun reverse() {
        var temp = head
        head = tail
        tail = temp

        var after: LLNode<T>?
        var before: LLNode<T>? = null

        repeat(length) {
            after = temp?.next
            temp?.next = before
            before = temp
            temp = after
        }
    }


    fun middle(): LLNode<T>? {
        var slow = head
        var fast = head

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }

}
