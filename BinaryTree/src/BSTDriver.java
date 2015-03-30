
public class BSTDriver {

	
	public static void main(String[] args){
		BST<Integer> tree = new BST<Integer>();
		
		BSTNode<Integer> a =new BSTNode<Integer>(15);
		BSTNode<Integer> b =new BSTNode<Integer>(5);
		BSTNode<Integer> c =new BSTNode<Integer>(7);
		BSTNode<Integer> d =new BSTNode<Integer>(13);
		BSTNode<Integer> e =new BSTNode<Integer>(11);
		BSTNode<Integer> f =new BSTNode<Integer>(9);
		BSTNode<Integer> g =new BSTNode<Integer>(18);
		BSTNode<Integer> h =new BSTNode<Integer>(10);
		BSTNode<Integer> i =new BSTNode<Integer>(49);
		BSTNode<Integer> j =new BSTNode<Integer>(68);
		BSTNode<Integer> k =new BSTNode<Integer>(12);
		BSTNode<Integer> l =new BSTNode<Integer>(3);


		
		
		
		tree.insert(a);
		tree.insert(b);
		tree.insert(c);
		tree.insert(d);
		tree.insert(e);
		tree.insert(f);
		tree.insert(g);
		tree.insert(h);
		tree.insert(i);
		tree.insert(j);
		tree.insert(k);
		tree.insert(l);

		
		

	

		

		System.out.println("Tree after inserts: ");
		System.out.println(tree.toString());
		System.out.println();
		tree.delete(a);

		tree.delete(e);
		System.out.println();
		System.out.println(tree.toString());
		tree.delete(j);
		System.out.println(tree.toString());





		


	}


}
