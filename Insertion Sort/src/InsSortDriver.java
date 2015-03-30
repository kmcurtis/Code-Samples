
public class InsSortDriver extends InsSort {


	public static void main(String[] args) {

		int[] list = makeList();
		long start = System.nanoTime();
		insertionSort(list);
		long end = System.nanoTime();
		long time = end-start;
		System.out.println("Execution time of Insertion Sort on file "+name+" with "+String.valueOf(size)+" elments took: "+time+"ns" );
		//printList(list); //This method prints the sort list to check if it is sorted. 

	}

}
