package Assignment1;

import java.util.ArrayList;

public class MyArrayListRunner {
    public static void main(String[] args) {
        Integer[] data = {0, 1, 2, 3, 4};
        MyArrayList<Integer> intList = new MyArrayList<Integer>(data);

        intList.print();

        intList.set(0, 400);

        intList.print();

        for(int i : data){
            System.out.println(i);
        }

    }
}
