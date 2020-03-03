package Assignment4;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

// 
// Decompiled by Procyon v0.5.36
// 

public class HeightTest
{
    protected BinarySearchTree<String> tree;

    @Before
    public void setUp() throws Exception {
        (this.tree = (BinarySearchTree<String>)new BinarySearchTree()).add("dog");
        this.tree.add("cat");
        this.tree.add("pig");
    }

    @Test
    public void testLeaf() {
        try {
            Assert.assertTrue("BinarySearchTree.height returns incorrect value when input value is leaf", 0 == this.tree.height("cat"));
        }
        catch (Exception ex) {
            Assert.fail("BinarySearchTree.height throws exception when input value is leaf: " + ex.toString());
        }
    }

    @Test
    public void testParentOfLeaves() {
        try {
            Assert.assertTrue("BinarySearchTree.height returns incorrect value when input value is parent of two leaf nodes", 1 == this.tree.height((String) "dog"));
        }
        catch (Exception ex) {
            Assert.fail("BinarySearchTree.height throws exception when input value is parent of two leaf nodes: " + ex.toString());
        }
    }
}