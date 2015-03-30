
public class RBTree<T extends Comparable<T>> extends BinarySearchTree<T> {

	RBTree<T> rbRoot;
	private Boolean black = true;
	private Boolean red = false;

	



	public void Insert(RBNode<T> z){
	
		RBNode<T> y = null;
		
		RBNode<T> x =  (RBNode<T>) this.root;


		while(x != null){
			y = x;

			
			if(z != null && z.getData().compareTo(x.getData()) == -1){
				x = (RBNode<T>) x.getLeft();
			}
			else{
				x = (RBNode<T>) x.getRight();
			}
		}

		z.parent = y;
		if(y  == null){
			this.root = z;
		}
		else if(z.getData().compareTo(y.getData()) == -1){
			y.setLeft(z);
		}
		else{
			y.setRight(z);
		}
		z.setLeft(null);
		z.setRight(null);
		z.setColor(red); 
		insertFixup(z);
	}		



	public void insertFixup(RBNode<T> z){
		RBNode<T> y = null;
		
		while(!z.equals(root) && z.parent.getColor() == red ){
			if(z.parent.equals(z.getGrandParent().getLeft())) {  //check
				y = (RBNode<T>) z.getGrandParent().getRight();
				
				if(y != null && y.getColor() == red){
					((RBNode<T>) z.parent).setColor(black);
					y.setColor(black);
					((RBNode<T>) z.getGrandParent()).setColor(red);
					z = z.getGrandParent();
					
				}
				else{ if(z.equals(z.parent.getParent())){
					
					z= z.parent;
					leftRotate(z);
					

				}
				z.getParent().setColor(black);
				z.getGrandParent().setColor(red);
				rightRotate(z.getGrandParent());
				}

			}
			else{
				y = (RBNode<T>) z.getGrandParent().getLeft();
				if(y != null &&y.getColor() == red){
					
					((RBNode<T>) z.parent).setColor(black);
					y.setColor(black);
					z.getGrandParent().setColor(red);
					z = z.getGrandParent();
				}
				else{ if(z == z.parent.getLeft()){
					z = z.parent;  
					rightRotate(z);

				}
				z.parent.setColor(black);
				z.getGrandParent().setColor(red);
			    leftRotate(z.getGrandParent());
				}
				

			}

		}
		((RBNode<T>) this.root).setColor(black);


	}
	
	
	public void leftRotate(RBNode<T> x){
		RBNode<T> y = new RBNode<T>();
		
		y = (RBNode<T>) x.getRight();
		x.setRight(y.getLeft());
		if(y.getLeft() !=  null){  
			y.getLeft().setParent(x); 
		}
		y.setParent(x.getParent());
		if(x.getParent() == null){ 
			root = y;
		}
		else if(x.getData().compareTo(x.getParent().getData()) == 0){
			x.getParent().setLeft(y);
		}
		else{
			x.getParent().setRight(y);
		}
		y.setLeft(x);
		x.parent = y;
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
			
			
			root = y;
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

	
	public String RbtoString() {
		if (this.root != null) {
			return ((RBNode<T>) root).RbtoStringPreOrder(".");
		} else {
			return "";
		}
	}


	
}
