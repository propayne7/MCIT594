package Assignment2;

public class Assignment2Runner {
    public static void main(String[] args) {
        MyLinkedList l1 = new MyLinkedList();

        l1.addFirst("One");
        l1.add(1, "Two");
        l1.add(2, "Three");
        l1.add(3, "Four");
        l1.add(4, "Five");
        l1.add(5, "Six");
        l1.add(6, "Seven");
        l1.add(7, "Eight");
        l1.add(8, "Nine");

        System.out.println("Original head: + " + l1.head.value);
        System.out.println("Original tail: + " + l1.tail.value);

        for (int i = 0; i < l1.size; i++){
            System.out.println(l1.get(i));
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        l1.reverse();


        System.out.println("New head: + " + l1.head.value);
        System.out.println("New tail: + " + l1.tail.value);

        for (int i = 0; i < l1.size; i++){
            System.out.println(l1.get(i));
        }


    }
}
