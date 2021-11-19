class LinkedList<T> {
    var head: Node<T>? = null
    var tail: Node<T>? = null

    /** Добавление элемента в голову связного списка. */
    fun push(x: T) {
        val node = Node(x)
        if (head == null) {   //если список пуст, то голова и хвост - это один узел
            head = node
            tail = node
        } else {
            head = Node(x, head) //новая голова теперь ссылается на "бывшую" первую
        }
    }

    /** Добавление элемента в хвост связного списка. */
    fun addTail(x: T) {
        val node = Node(x)
        if (head == null) {    //если список пуст, то голова и хвост - это один узел
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
}