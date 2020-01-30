package Assignment2;

public class MyLinkedList {

    class Node {
        String value;
        Node next = null;
        Node(String value) {
            this.value = value;
        }
    }

    protected Node head = null;
    protected Node tail = null;
    protected int size = 0;


    public void addFirst(String value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(String value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void add(int index, String value) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(value);
        }
        else {
            Node newNode = new Node(value);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                if (current == null) throw new IndexOutOfBoundsException();
                current = current.next;
            }
            if (current.next == null) { tail = newNode; }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public String get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                if (current == null || current.next == null) {
                    throw new IndexOutOfBoundsException();
                }
                current = current.next;
            }
            return current.value;
        }
    }


    public boolean contains(String value) {
        Node current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
        if (head == null) {
            tail = null;
        }
        if (size > 0) size--;
    }

    public void removeLast() {
        if (head == null) { //empty list
            return;
        } else if (head == tail) {
            //single element list
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
        size--;
    }

    /*
        Method to return the node from a specified index
     */
    public Node getNode(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                if (current == null) {
                    throw new IndexOutOfBoundsException();
                }
                current = current.next;
            }
            return current;
        }
    }

    public void remove(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        else if (index == 0) removeFirst();
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                if (current == null) throw new IndexOutOfBoundsException();
                current = current.next;
            }
            current.next = current.next.next;
            if (current.next == null) {
                tail = current;
            }
            size--;
        }
    }



    /*
     * Implement the methods below.
     * Please do not change their signatures!
     */

    /*
        REVERSE linked list:
            - create new linked list as a temporary holder
            - for ea node in descending order
            - add to new linked list
            - set linked list = to temp linked list
     */
    public void reverse() {
        // create an array to hold the current nodes
        Node[] currentNodes = new Node[size];
        // iterate through the linked list to add the nodes to the currentNodes array
        for(int i = 0; i < size; i++){
            currentNodes[i] = getNode(i);
        }

        head = currentNodes[size - 1];
        tail = currentNodes[0];

        for(int i = size - 1; i > 0; i--) {
            Node currentNode = currentNodes[i];
            System.out.println("Current node value: " + currentNode.value);
            currentNode.next = currentNodes[i - 1];
        }
    }


    public void removeMaximumValues(int N) {
        /* IMPLEMENT THIS METHOD! */

    }


    public boolean containsSubsequence(MyLinkedList two) {
        /* IMPLEMENT THIS METHOD! */

        return false;
    }



}