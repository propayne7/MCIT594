package Assignment1;

import java.util.ArrayList;

public class MyArrayListRunner {
    public static void main(String[] args) {
        MyArrayList<Integer> intList = new MyArrayList<>();
//        MyArrayList<String> stringList = new MyArrayList<>();
//        MyArrayList<Boolean> booleanList = new MyArrayList<>();

//        intList.add(1);
//        booleanList.add(false);
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(40);
        intList.add(null);
        intList.add(50);

        System.out.println("The first item in intList is: " + intList.get(0));
//        System.out.println("The second item in intList is: " + stringList.get(0));
//        System.out.println("The third item in intList is: " + booleanList.get(0));

        for(int i = 0; i < intList.size; i++){
            System.out.println("Size of string list is: " + intList.size);
            System.out.println("Current index: " + i);
            System.out.println("Current element: " + intList.get(i));
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("Removing element at index 2");
        intList.remove(Integer.valueOf(20));

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        for(int i = 0; i < intList.size; i++){
            System.out.println("Size of string list is: " + intList.size);
            System.out.println("Current index: " + i);
            System.out.println("Current element: " + intList.get(i));
        }

    }
}
