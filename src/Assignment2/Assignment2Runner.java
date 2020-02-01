package Assignment2;

public class Assignment2Runner {
    public static void main(String[] args) {
        MyLinkedList l3 = new MyLinkedList();
        MyLinkedList l4 = new MyLinkedList();

        l3.add(0,"KANGAROO");
        l3.add(1,"PLATYPUS");
        l3.add(2,"AARDVARK");
        l3.add(3,"KANGAROO");
        l3.add(4,"DONKEY");
        l3.add(5,"COYOTE");

        l4.add(0, "CO");

        System.out.println("Testing the containsSubsequence: " + l3.containsSubsequence(l4));

    }
}
