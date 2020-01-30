package Week2LinkedLists;

public class LinkedList<E> {
    class Node {
        E value;
        Node next;

        Node(E value) {
            this.value = value;
        }
    }

    protected Node head = null;
    protected Node tail = null;


    public void addFirst(E value) {
        Node newNode = new Node(value);
        // set the newNode's next value to be the head
        newNode.next = head;
        // reassign the current head to newNode (puts newNode at the front of the list)
        head = newNode;

        if (tail == null) {
            tail = newNode;
        }
    }

    public void addLast(E value) {
        Node newNode = new Node(value);
        // sets the current tail to have a next value equal to newNode
        tail.next = newNode;
        // reassigns the current value of tail to the newNode
        tail = newNode;
    }

    public void add(int index, E value) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(value);
        } else {
            Node newNode = new Node(value);
            Node current = head;

            for (int i = 0; i < index - 1; i++) {
                if (current == null) throw new IndexOutOfBoundsException();
                current = current.next;
            }

            if (current.next == null) {
                tail = newNode;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void removeFirst() {
        if (head != null) {
            // change head value to point to the node immediately after the head (node in position 2)
            // this makes the second node become the first node
            head = head.next;
        }
        // handle the case where there is only one node in the linked list
        if (head == null) {
            tail = null;
        }
    }

    public void removeLast() {
        if (head == null) {
            // empty list
            return;
        } else if (head == tail) {
            // single element list
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            current.next = null;
        }
    }

    public void remove(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        else if (index == 0) {
            removeFirst();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                if (current.next == null)
                    current = current.next;
            }
            current.next = current.next.next;
            if (current.next == null) {
                tail = current;
            }
        }
    }

    public boolean contains(E value){
        Node current = head;
        while(current != null){
            if(current.value.equals(value)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E get(int index){
        if(index < 0) throw new IndexOutOfBoundsException();
        if(index == 0){ return head.value; }

        Node current = head;
        for(int i = 0; i < index; i++) {
            if (current.next == null || current == null) {
                throw new IndexOutOfBoundsException();
            }
            current = current.next;
        }
        return current.value;
    }
}
