
public class BSTNode<T> extends BinaryTreeNode<T> {

BinaryTreeNode<T> parent = super.parent;

public BSTNode() {
	super(null, null, null);
	
}

public BSTNode(T theData) {
	super(theData);
}

}
