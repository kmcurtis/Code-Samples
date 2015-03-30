
public class BST<T extends Comparable<T>> extends BinaryTree<T> {

	

	public void insert(T num){

		BinaryTreeNode<T> z= new BinaryTreeNode<T>(num);

		BinaryTreeNode<T> y = null;
		BinaryTreeNode<T> x = this.root;

		while(x != null){
			y = x;

			if(z.getData().compareTo(x.getData())== -1){
				x = x.getLeft();
			}
			else
				x = x.getRight();
		}

		z.setParent(y);

		if(y== null){
			this.root = (BSTNode<T>) z;
		}
		else if(z.getData().compareTo(y.getData()) ==-1){
			y.setLeft(z);
		}
		else
			y.setRight(z);


	}

	public void insert(BSTNode<T> z){



		BinaryTreeNode<T> y = null;
		BinaryTreeNode<T> x = this.root;

		while(x != null){
			y = x;

			if(z.getData().compareTo(x.getData())== -1){
				x = x.getLeft();
			}
			else
				x = x.getRight();
		}

		z.setParent(y);

		if(y== null){
			this.root = z;
		}
		else if(z.getData().compareTo(y.getData()) ==-1){
			y.setLeft(z);
		}
		else
			y.setRight(z);


	}

	public void search( BSTNode<T> x, T k){

		if(x == null ){

			System.out.println("Element not found");

			return;
		}

		if( k.compareTo(x.getData()) == 0){
			System.out.println("Element found");

			return;
		}

		if(k.compareTo(x.getData()) == -1){
			search((BSTNode<T>) x.getLeft(),k);
		}
		else{
			search((BSTNode<T>) x.getRight(),k);
		}
	}




	public void delete(BSTNode<T> z){

		BSTNode<T> y = new BSTNode<>();

		if(z.getLeft() == null){
			Transplant(z, (BSTNode<T>) z.getRight());
		}
		else if(z.getRight() == null){
			Transplant(z, (BSTNode<T>) z.getLeft());
		}
		else{
			y = TreeMin((BSTNode<T>) z.getRight());

			if(y.getParent() != z){
				Transplant(y, (BSTNode<T>) y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}
			Transplant(z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
		}

	}

	public void Transplant(BSTNode<T> u, BSTNode<T> v){
		if(u.getParent() == null){
			this.root = v;
		}
		else if (u == u.getParent().getLeft()){
			u.getParent().setLeft(v);
		}
		else{
			u.getParent().setRight(v);
		}

		if(v != null){
			v.setParent(u.getParent());
		}
	}

	public BSTNode<T> TreeMin(BSTNode<T> x) {
		while(x.getLeft() != null){
			x = (BSTNode<T>) x.getLeft();
		}
		return x;
	}

	public String parentToString(){
		return super.toString();
	}

	public void inOrderTreeWalk(BSTNode<T> x){
		this.toRoot();
		if(x != null){
			inOrderTreeWalk((BSTNode<T>) x.getLeft());
			System.out.print(x.getData()+" ");
			inOrderTreeWalk((BSTNode<T>) x.getRight());
		}
	}

}
