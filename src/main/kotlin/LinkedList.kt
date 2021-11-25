class LinkedList<T> {
    var head: Node<T>? = null
    var tail: Node<T>? = null

    override fun toString() = head?.toString() ?: "empty list"

    val isEmpty: Boolean get() {
        return head == null
    }

    /** Добавление элемента в голову связного списка. */
    fun push(x: T) {
        val node = Node(x)
        if (isEmpty) {   //если список пуст, то голова и хвост - это один узел
            head = node
            tail = node
        } else {
            head = Node(x, head) //новая голова теперь ссылается на "бывшую" первую
        }
    }

    /** Добавление элемента в хвост связного списка. */
    fun addTail(x: T) {
        val node = Node(x)
        if (isEmpty) {    //если список пуст, то голова и хвост - это один узел
            head = node
            tail = node
        } else {
            tail?.next = node  //иначе "старый" последний элемент теперь ссылается на новый
            tail = node        //а в указатель на последний элемент записываем адрес нового элемента
        }
    }

    /** Удаление элемента из головы связного списка. */
    fun pop(): T? {
        val value = head?.value
        head = head?.next
        return value
    }

    /*
          Задача. Найти середину связного списка за один проход по св. списку.
     */

    fun findMiddle(): Node<T>? {
        var node = head
        var node2 = head
        while (node != null && node2?.next != null) {
            node = node.next
            node2 = node2.next?.next
        }
        return node
    }

    private fun findByIndex(index: Int): Node<T>? {
        var node = head
        var i = 0
        while(node != null && i < index) {
            node = node.next
            i++
        }
        return node
    }

    fun removeAtIndex(index: Int): T? {
        val prevEl = findByIndex(index-1)
        val element = prevEl?.next
        val nextEl = element?.next
        prevEl?.next = nextEl
        element?.next = null
        return element?.value
    }
}