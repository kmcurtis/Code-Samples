public class BinaryTreeNode<T>  {
	protected BinaryTreeNode<T> left; // the left child
	protected BinaryTreeNode<T> right; // the right child
	BinaryTreeNode<T> parent;
	protected T data; // the data in this node

	public BinaryTreeNode() {
		this(null, null, null);
		
	}

	public BinaryTreeNode(T theData) {
		this(theData, null, null);
	}

	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild,
			BinaryTreeNode<T> rightChild) {
		data = theData;
		left = leftChild;
		right = rightChild;
	}

	public T getData() {
		return data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}
	
	public BinaryTreeNode<T> getParent() {
		return parent;
	}

	public void setLeft(BinaryTreeNode<T> newLeft) {
		left = newLeft;
	}

	public void setRight(BinaryTreeNode<T> newRight) {
		right = newRight;
	}
	
	public void setParent(BinaryTreeNode<T> newParent) {
		parent = newParent;
	}


	public void setData(T newData) {
		data = newData;
	}

	public void preOrder() {
		System.out.println(data);

		if (left != null) {
			left.preOrder();
		}

		if (right != null) {
			right.preOrder();
		}
	}

	public int height() {
		int leftHeight = 0; // Height of the left subtree
		int rightHeight = 0; // Height of the right subtree
		int height = 0; // The height of this subtree

		// If we have a left subtree, determine its height
		if (left != null) {
			leftHeight = left.height();
		}

		// If we have a right subtree, determine its height
		if (right != null) {
			rightHeight = right.height();
		}

		// The height of the tree rooted at this node is one more than the
		// height of the 'taller' of its children.
		if (leftHeight > rightHeight) {
			height = 1 + leftHeight;
		} else {
			height = 1 + rightHeight;
		}

		// Return the answer
		return height;
	}

	public String toStringPreOrder(String pathString) {
		String treeString = pathString + " : " + data + "\n";

		if (left != null) {
			treeString += left.toStringPreOrder(pathString + "L");
		}

		if (right != null) {
			treeString += right.toStringPreOrder(pathString + "R");
		}

		return treeString;
	}
	
	

	

}
