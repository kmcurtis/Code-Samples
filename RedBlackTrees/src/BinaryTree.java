public class BinaryTree<T> {
	protected BinaryTreeNode<T> root; // the root of the tree
	protected BinaryTreeNode<T> cursor; // the current node


	public void toRoot() {
		cursor = root;
	}

	public boolean hasLeftChild() {
		return cursor.getLeft() != null;
	}

	public boolean hasRightChild() {
		return cursor.getRight() != null;
	}

	public void toLeftChild() {
		cursor = cursor.getLeft();
	}

	public void toRightChild() {
		cursor = cursor.getRight();
	}


	public T get() {
		return cursor.getData();
	}

	public void set(T data) {
		cursor.setData(data);
	}

	public int height() {
		if (root != null) {
			return root.height();
		} else {
			return 0;
		}
	}

	public String toString() {
		if (root != null) {
			return root.toStringPreOrder(".");
		} else {
			return "";
		}
	}


}
