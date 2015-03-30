
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

	

	
	
	public void Insert(BSTNode<T> z){
		BSTNode<T> y = null;
		BSTNode<T> x = (BSTNode<T>) this.root;
		
		while(x != null){
			y = x;
			if((z.getData().compareTo(x.getData()) == -1)){
				x = (BSTNode<T>) x.getLeft();
			}
			else{
				x = (BSTNode<T>) x.getRight();
			}
		}
		z.parent = y;
		if(y == null){
			this.root = z;
		}
		else if(z.getData().compareTo(y.getData()) == -1){
			y.setLeft(z);
		}
		else
			y.setRight(z);
		
			
			
		
	}
	

	public T Search(BSTNode<T> x, T k){
		
		if(x == null){
			return null;
		}
		else if(k == x.getData()){
			return x.getData();
		}
			
		
		else if(k.compareTo( x.getData()) == -1){
			
			return Search((BSTNode<T>) x.getLeft(), k);
		}
		else return Search((BSTNode<T>) x.getRight(), k);
	}
	
	public void inOrderWalk(BSTNode<T> x){
		
		if(x != null){
			inOrderWalk((BSTNode<T>) x.getLeft());
			System.out.println(x.getData().toString());
			inOrderWalk((BSTNode<T>) x.getRight());
		}
		
	}
	
	public void delete(BSTNode<T> z){
		BSTNode<T> y = null;
		if(z.getLeft() == null){
			this.Transplant(z, (BSTNode<T>) z.getRight());
		}
		else if(z.getRight() == null){
			this.Transplant(z, (BSTNode<T>) z.getLeft());
		}
		else{
			y = (BSTNode<T>) z.getRight().getLeft();
			if(y.getParent() != z){ //hereer
				this.Transplant(y, (BSTNode<T>) y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
				
			}
			this.Transplant(z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
		}
		
	}
	
	public void Transplant(BSTNode<T> u, BSTNode<T> v){
		if(u.parent == null){
			this.root = v;
		}
		else if(u == u.parent.getLeft()){
			u.parent.setLeft(v);
		}
		else{
			u.parent.setRight(v);
		}
		if(v != null){
			v.setParent(u.parent); //Herer
		}
	}


	





}
