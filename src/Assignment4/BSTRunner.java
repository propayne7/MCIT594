package Assignment4;

public class BSTRunner {

    public static void main(String[] args) {
        BinarySearchTree<Integer> BST = new BinarySearchTree<>();
        BST.add(8);
        BST.add(6);
        BST.add(16);
        BST.add(4);
        BST.add(10);
        BST.add(20);
        BST.add(2);
        BST.add(9);
        BST.add(12);



        System.out.println(BST.maxValue(BST.root));
        System.out.println(BST.depth(12));
        System.out.println(BST.height(10));



    }

}
