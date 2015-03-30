import java.util.Arrays;


public class SortsDriver extends HeapSort {

	public static void heapTime(int[] arr){
		long start = System.nanoTime();
		heapSort(arr);
		long end = System.nanoTime();
		long time = end-start;
		System.out.println("Heap sort took "+time+"ns\n");
	}

	public static void insTime(int[] arr){
		long start = System.nanoTime();
		insertionSort(arr);
		long end = System.nanoTime();
		long time = end-start;
		System.out.println("Insertion sort took "+time+"ns\n");
	}

	public static void mrgTime(int[] arr, int[] temp, int p, int r){
		long start = System.nanoTime();
		mergeSort(arr, temp, p, r);
		long end = System.nanoTime();
		long time = end-start;
		System.out.println("Merge sort took "+time+"ns\n");
	}


	public static void main(String[] args) {
		filePicker();
		int[] origi = makeList();

		int[] arrH = Arrays.copyOf(origi, origi.length);
		int[] arrI = Arrays.copyOf(arrH, arrH.length);
		int[] arrM = Arrays.copyOf(arrH, arrH.length);
		int[] temp = Arrays.copyOf(arrH, arrH.length);
		
		heapTime(arrH);
		mrgTime(arrM, temp, 0, arrM.length-1);
		insTime(arrI);

		

	}

}
