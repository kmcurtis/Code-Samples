import java.util.ArrayList;
import java.util.Scanner;


public class test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a the size of the tree");
		int size= scan.nextInt();
		
	BinarySearchTree<Integer> tree = new BinarySearchTree<>();
	ArrayList<BSTNode<Integer>> node = new ArrayList<BSTNode<Integer>>();
	
	for(int i = 0; i < size; i++){
		System.out.print("Number "+ (i+1) +":");
		node.add(new RBNode<Integer>(scan.nextInt()));
		tree.Insert(node.get(i));
		System.out.println();
	}
	scan.close();

	System.out.println(tree.toString());
	
		
	
		
	


	
	}

	

}
