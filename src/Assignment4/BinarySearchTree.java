package Assignment4;

public class BinarySearchTree<E extends Comparable<E>> {
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;
		Node(E value) {
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			Node other = (BinarySearchTree.Node)obj;
			return other.value.compareTo(value) == 0 &&
					other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}
	
	protected Node root = null;
	
	protected void visit(Node n) {
		System.out.println(n.value);
	}
	
	public boolean contains(E val) {
		return contains(root, val);
	}
	
	protected boolean contains(Node n, E val) {
		if (n == null) return false;
		
		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}
	
	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}
	
	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			} 	
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			} 	
		}
	}	
	
	public boolean remove(E val) {
		return remove(root, null, val);
	}
	
	protected boolean remove(Node n, Node parent, E val) {
		if (n == null) return false;

		if (val.compareTo(n.value) == -1) {
				return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) == 1) {
				return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n){
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
	    } else {
	       return maxValue(n.rightChild);
	    }
	}

	
	/*
	 * Implement the methods below.
	 */

	// Method #1.
	public Node findNode(E val) {
		// error handling when val is null
		if(val == null){
			return null;
		}

		if(!contains(val)){
			return null;
		}

		Node foundNode = findNode(root, null, val);

		return foundNode;
	}

	// protected method called by the public findNode method. this method is used to traverse the tree.
	protected Node findNode(Node n, Node parent, E val){
		// handle case where the root
		if(n == null){
			return null;
		}

		if(n.value.equals(val)){
			return n;
		}

		if(val.compareTo(n.value) < 0){

			if(n.leftChild == null){
				return null;
			}
			Node foundNode = findNode(n.leftChild, n, val);
			return foundNode;
		} else {
			if(n.rightChild == null){
				return null;
			}

			Node foundNode = findNode(n.rightChild, n, val);
			return foundNode;
		}
	}
	
	// Method #2.
	protected int depth(E val) {
		if(val == null){
			return -1;
		}

		if(!contains(val)){
			return -1;
		}

		return depth(root, null, val);
	}

	protected int depth(Node n, Node parent, E val){
		if(n == null){
			return -1;
		}

		int dist = -1;

		// first check is the base case, where the current node's value == 0. If this check returns true before the recursive
		// step, then the root value contains the desired value and the depth is 0.
		if((val.compareTo(n.value) == 0) || (dist = depth(n.leftChild, n, val)) >= 0 || (dist = depth(n.rightChild, n, val)) >= 0){
			return dist + 1;
		}

		return dist;
	}
	
	// Method #3.
	protected int height(E val) {
		// handle the case where val == null
		if(val == null){
			return - 1;
		}
		// handle the case where val does not exist in the tree
		if(!contains(val)){
			return - 1;
		}

		Node currentNode = findNode(root, null, val);

		return height(currentNode);
	}

	private int height(Node n){
		if(n == null){
			return -1;
		}

		int leftHeight = height(n.leftChild);
		int rightHeight = height(n.rightChild);

		if(leftHeight > rightHeight){
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}
	
	// Method #4.
	protected boolean isBalanced(Node n) {
		if(n == null){
			return true;
		}

		int leftHeight;
		int rightHeight;

		leftHeight = height2(n.leftChild);
		rightHeight = height2(n.rightChild);

		System.out.println("Left height: " + leftHeight);
		System.out.println("Right height: " + rightHeight);

		if(Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(n.leftChild) && isBalanced(n.rightChild)){
			return true;
		}


		return false;
	}

	protected int height2(Node n){
		if(n == null){
			return 0;
		}
		return 1 + Math.max(height2(n.leftChild), height2(n.rightChild));
	}

	// Method #5. 
	public boolean isBalanced() {
		return isBalanced(root);
	}
	
}
