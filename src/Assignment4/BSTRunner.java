package Assignment4;

public class BSTRunner {

    public static void main(String[] args) {
        BinarySearchTree<Integer> BST = new BinarySearchTree<>();
        BST.add(10);
        BST.add(4);
        BST.add(15);
        BST.add(20);
        BST.add(1);
        BST.add(7);
        BST.add(3);


        BST.remove(15);

        System.out.println(BST.maxValue(BST.root));

        System.out.println(BST.findNode(null).value);
        System.out.println(BST.findNode(3).value);



    }

}
