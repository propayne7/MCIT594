package Week2LinkedLists;

public class LinkedListRunner {
    public static void main(String[] args) {
        LinkedList<String> l1 = new LinkedList<>();

        l1.addFirst("Chris");
        l1.addLast("Amanda");
        l1.addFirst("Evey");
        l1.addLast("Cambo");

        l1.add(3,"Todd");

        System.out.println(l1.tail.value);

        l1.head = l1.tail;

        System.out.println(l1.tail.value);

    }
}
