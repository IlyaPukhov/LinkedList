fun main() {
    val list = LinkedList<Int>()
    list.push(14)
    list.addTail(10)
    list.push(12)
    list.addTail(17)
    list.addTail(19)
    println(list.head)
    list.pop()
    println(list.head)
    list.removeAtIndex(2)
    println(list.head)
}