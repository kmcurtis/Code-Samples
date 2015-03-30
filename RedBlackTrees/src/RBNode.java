
public class RBNode<T extends Comparable<T>> extends BSTNode<T> {
	Boolean color;
	Boolean black = true;
	Boolean red = true;
	Boolean pcolor;
	private RBTree<T> rooot;
	RBNode<T> parent;
	RBNode<T> gParent;
	String des;
	
	
	
	public RBNode(T data){
		super(data);
		
		
	}
	public RBNode(T i, Boolean col){
		super(i);
		
	}
	
	public RBNode(T i, Boolean col, String descr){
		super(i);
		setDescr(descr);
		
	}

	public RBNode() {
	super();
}
	
	public RBNode(T i, String string) {
		super(i);
		setDescr(string);
	}
	public RBNode<T> getParent() {
		return parent;
	}
	
	public void setParent(RBNode<T> newParent) {
		
		parent = newParent;
		
	}
	
	public RBNode<T> getGrandParent() {
		return parent.parent;
	}
	
	public void setGrandParent(RBNode<T> newGParent) {
		gParent = newGParent;
	}

	public boolean getColor() {
		return this.color;
	}

	public void setColor(Boolean newColor) {
		color = newColor;
	}
	
	public Boolean getParentColor()
	{
		if(this.parent.getData() != null){
			return this.parent.color;
		}
		else
			return null;
	}
	
	public void setParentColor(Boolean parentColor)
	{
		pcolor = parentColor;
	}
	
	public String getDescr() {
		return this.des;
	}
	
	public void setDescr(String d) {
	
		des = d;
	}
	
	public void leftRotate(RBNode<T> x){
		RBNode<T> y = new RBNode<T>();
		
		y.setData(x.getRight().getData());
		x.setRight(y.getLeft());
		if(y.getLeft() !=  null){  
			y.getLeft().setParent(x); 
		}
		y.setParent(x.getParent());
		if(x.getParent() == null){ 
			rooot.set(y.getData());
		}
		else if(x.getData().compareTo(x.getParent().getData()) == 0){
			x.getParent().setLeft(y);
		}
		else{
			x.getParent().setRight(y);
		}
		y.setLeft(x);
		x.setParent(y);
	}
	
	public void rightRotate(RBNode<T> x){
		RBNode<T> y = new RBNode<T>();
		y.setData(x.getLeft().getData());
		x.setLeft(y.getRight());
		if(y.getRight() !=  null){  
			y.getRight().setParent(x); 
		}
		y.setParent(x.getParent());
		if(x.getParent() == null){ 
			
			this.rooot = y.rooot;
		}
		else if(x.getData().compareTo(x.getParent().getData()) == 0){
			x.getParent().setRight(y);
		}
		else{
			x.getParent().setLeft(y);;
		}
		y.setRight(x);
		x.setParent(y);
	}
	
	
	
	public void RbpreOrder() {
		System.out.print(data);

		if (left != null) {
			((RBNode<T>) left).preOrder();
		}

		if (right != null) {
			((RBNode<T>) right).preOrder();
		}
	}
	
	
	
	public String RbtoStringPreOrder(String pathString) {
		String color ="";
		if(this != null && this.color != null){
			if(this.getColor() == black){
				color = "black";
			}
			else
				color = "red";
		}
		
		String treeString = pathString + " : " + data +" "+ color +"\n";

		if (left != null) {
			treeString += ((RBNode<T>) left).RbtoStringPreOrder(pathString + "L");
		}

		if (right != null) {
			treeString += ((RBNode<T>) right).RbtoStringPreOrder(pathString + "R");
		}

		return treeString;
	}
	


}
