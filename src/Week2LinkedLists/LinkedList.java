package Week2LinkedLists;

public class LinkedList<E> {
    class Node {
        E value;
        Node next;
        Node(E value){
            this.value = value;
        }
    }

    protected Node head = null;
    protected Node tail = null;

}
