
import java.util.ArrayList;
import java.util.Scanner;


public class RBDriver {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a the size of the tree");
		int size= scan.nextInt();
		
	RBTree<Integer> tree = new RBTree<>();
	ArrayList<RBNode<Integer>> node = new ArrayList<RBNode<Integer>>();
	
	for(int i = 0; i < size; i++){
		System.out.print("Number "+ (i+1) +":");
		node.add(new RBNode<Integer>(scan.nextInt()));
		tree.Insert(node.get(i));
		System.out.println();
	}
	scan.close();

		System.out.println(tree.RbtoString());
	
		
	
		
	


	
	}
}
