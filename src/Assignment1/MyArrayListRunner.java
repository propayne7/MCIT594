package Assignment1;

import java.util.ArrayList;

public class MyArrayListRunner {
    public static void main(String[] args) {
        MyArrayList<Integer> intList = new MyArrayList<>();
        MyArrayList<String> stringList = new MyArrayList<>();
        MyArrayList<Boolean> booleanList = new MyArrayList<>();

        intList.add(1);
        booleanList.add(false);
        stringList.add("Test");

        System.out.println(intList.get(0));
        System.out.println(stringList.get(0));
        System.out.println(booleanList.get(0));
    }
}
