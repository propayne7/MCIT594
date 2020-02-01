package Assignment2;

public class Assignment2Runner {
    public static void main(String[] args) {
        MyLinkedList l2 = new MyLinkedList();

        l2.add(0,"KANGAROO");
        l2.add(1,"PLATYPUS");
        l2.add(2,"AARDVARK");
        l2.add(3,"KANGAROO");
        l2.add(4,"DONKEY");
        l2.add(5,"COYOTE");

        l2.removeMaximumValues(2);

        System.out.println("Head: " + l2.head.value);
        System.out.println("Tail: " + l2.tail.value);

        for(int i = 0; i < l2.size; i++){
            System.out.println(l2.get(i));
        }

    }
}
