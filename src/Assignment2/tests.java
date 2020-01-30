package Assignment2;

import org.junit.Test;
import org.junit.Assert;

public class tests {
    final MyLinkedList l1 = new MyLinkedList();
    final MyLinkedList l2 = new MyLinkedList();

    @Test
    public void testReverse(){
        l1.addFirst("alpha");
        l1.add(1, "bravo");
        l1.add(2, "charlie");
        l1.add(3, "delta");
        l1.reverse();
        Assert.assertTrue("Reverse not setting the correct Head value.", l1.head.value.equals("delta"));
        Assert.assertTrue("Reverse not setting the correct Tail value.", l1.tail.value.equals("alpha"));
        Assert.assertTrue("Reverse not setting the correct 'next' values", l1.head.next.value.equals("charlie"));
        Assert.assertTrue("Reverse not setting the correct 'next' values", l1.head.next.next.value.equals("bravo"));

    }

    @Test
    public void testRemoveMaxValues(){

    }
}
