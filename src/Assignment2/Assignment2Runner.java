package Assignment2;

public class Assignment2Runner {
    public static void main(String[] args) {
        MyLinkedList l1 = new MyLinkedList();

        l1.addFirst("DOG");
        l1.add(1, "BANANA");
        l1.add(2, "CAT");
        l1.add(3, "GORILLA");
        l1.add(4, "BEAR");
        l1.add(5, "GORILLA");
        l1.addLast("GORILLA");
        System.out.println("Head: " + l1.head.value);
        System.out.println("Tail: " + l1.tail.value);

        for(int i = 0; i < l1.size; i++){
            System.out.println(l1.get(i));
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        l1.removeMaximumValues(1);

        for(int i = 0; i < l1.size; i++){
            System.out.println(l1.get(i));
        }

        System.out.println("New head: " + l1.head.value);
        System.out.println("New tail: " + l1.tail.value);

    }
}
