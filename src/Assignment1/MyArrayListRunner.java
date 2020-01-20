package Assignment1;

import java.util.ArrayList;

public class MyArrayListRunner {
    public static void main(String[] args) {
        String[] array = { "a", "b", "c", "d", "e", "f" };
        MyArrayList list = new MyArrayList();

        String[] array2 = array;

        for (int length = array2.length, i = 0; i < length; i++) {
            list.add((Object)array2[i]);
        }

        list.print();
        System.out.println("Initial size: " + list.size);
        System.out.println(list.data.length);
        System.out.println();

//        list.remove(0);
//        list.remove(0);
//        list.remove(0);
//        list.remove(0);
//        list.remove(0);
        list.remove("a");
        list.remove("b");
        list.remove("c");
        list.remove("d");
        list.remove("e");

        list.print();
        System.out.println("Modified size: " + list.size);
        System.out.println(list.data.length);

    }
}
