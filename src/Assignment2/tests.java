package Assignment2;

import org.junit.Test;
import org.junit.Assert;

public class tests {
    final MyLinkedList l1 = new MyLinkedList();
    final MyLinkedList l2 = new MyLinkedList();

    public void populate_l1(){
        l1.addFirst("alpha");
        l1.add(1, "bravo");
        l1.add(2, "charlie");
        l1.add(3, "delta");
        l1.reverse();
    }

    public void populate_l2(){
        l2.add(0,"KANGAROO");
        l2.add(1,"PLATYPUS");
        l2.add(2,"AARDVARK");
        l2.add(3,"KANGAROO");
        l2.add(4,"DONKEY");
        l2.add(5,"COYOTE");
        l2.removeMaximumValues(2);
    }


    @Test
    public void testReverseHead() {
        populate_l1();
        Assert.assertTrue("reverse() method not setting the correct Head value.", l1.head.value.equals("delta"));
    }

    @Test
    public void testReverseTail(){
        populate_l1();
        Assert.assertTrue("reverse() method not setting the correct Tail value.", l1.tail.value.equals("alpha"));
    }

    @Test
    public void testReverseValues(){
        populate_l1();
        Assert.assertTrue("reverse() method not setting the correct 'next' values", l1.head.next.value.equals("charlie"));
        Assert.assertTrue("reverse() method not setting the correct 'next' values", l1.head.next.next.value.equals("bravo"));
    }

    @Test
    public void testRemoveMaxValuesHead() {
        populate_l2();
        Assert.assertTrue("removeMaxValues() method is not removing the correct values.", l2.head.value.equals("AARDVARK"));
    }

    @Test
    public void testRemoveMaxValuesTail(){
        Assert.assertTrue("removeMaxValues() method is not removing the correct values.", l2.tail.value.equals("COYOTE"));
    }

    @Test
    public void testRemoveMaxValuesInnerValues(){
        populate_l2();
        Assert.assertTrue("removeMaxValues() method is not removing the correct values.", l2.head.next.value.equals("DONKEY"));
    }
}
