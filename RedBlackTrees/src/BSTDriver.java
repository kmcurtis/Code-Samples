
public class BSTDriver<T> {

	public static void main(String[] args){

		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		BSTNode<Integer> a =  new BSTNode<>(42);
		BSTNode<Integer> b =  new BSTNode<>(25);
		BSTNode<Integer> c =  new BSTNode<>(65);
		BSTNode<Integer> d =  new BSTNode<>(12);
		BSTNode<Integer> e =  new BSTNode<>(37);
		BSTNode<Integer> f =  new BSTNode<>(13);
		BSTNode<Integer> g =  new BSTNode<>(30);
		BSTNode<Integer> h =  new BSTNode<>(43);
		BSTNode<Integer> i =  new BSTNode<>(87);
		BSTNode<Integer> j =  new BSTNode<>(99);
		BSTNode<Integer> k =  new BSTNode<>(9);
		BSTNode<Integer> l =  new BSTNode<>(-77);
		
		
	

	

		tree.Insert(a); //42
		tree.Insert(b); //25
		tree.Insert(c); //65
		tree.Insert(d); //12
		tree.Insert(e); //37
		tree.Insert(f); //13
		tree.Insert(g); //30
		tree.Insert(h); //43
		tree.Insert(i); //87
		tree.Insert(j); //99
		tree.Insert(k);  //9
		tree.Insert(l);

		System.out.println(tree.toString());

System.out.println(tree.Search((BSTNode<Integer>) tree.root, 42));

		





	}
}
