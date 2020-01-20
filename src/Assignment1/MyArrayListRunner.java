package Assignment1;

import java.util.ArrayList;

public class MyArrayListRunner {
    public static void main(String[] args) {
        MyArrayList<Integer> intList = new MyArrayList<>();

        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(null);
        intList.add(null);
        intList.add(null);
        intList.add(null);
        intList.add(null);


        intList.print();

        int originalValue = intList.set(1,100);

        System.out.println("Original value: " + originalValue);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        intList.print();

    }
}
