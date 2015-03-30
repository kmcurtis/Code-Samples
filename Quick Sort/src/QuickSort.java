import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort extends InsSort {

	static String name;
	static int fileSize = 0;
	static int cutoff;

	public static boolean sortCheckAsc(int[] a) {
		int N = a.length;
		int prev = a[0];
		boolean isSorted = true;
		for (int i = 1; i < N; i++) {
			if (a[i] >= prev) {
				continue;
			} else {
				isSorted = false;
				return isSorted;
			}
		}
		return isSorted;
	}

	public static int[] makeList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] newList = null;
		File file = new File(name);
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextInt()) {
				list.add(scan.nextInt());
			}
			scan.close();
			fileSize = list.size();
			newList = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				newList[i] = list.get(i);
			}
			System.out.println("List size is " + newList.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return newList;

	}

	// Method that prompts user for a number that corresponds to the input file
	public static String filePicker() {
		String file = null;

		System.out
		.println("Choose a file to run Quick Sort on by entering one of the numbers from to select the corresponding file: ");
		System.out
		.println("File Number List: Pick a number ranging from 4 - 24");
		System.out.println("File will have 2^N elements");
		String num = StdIn.readString();

		switch (num) {
		case "4":
			file = "input_2_4.txt";
			break;
		case "5":
			file = "input_2_5.txt";
			break;
		case "6":
			file = "input_2_6.txt";
			break;
		case "7":
			file = "input_2_7.txt";
			break;
		case "8":
			file = "input_2_8.txt";
			break;
		case "9":
			file = "input_2_9.txt";
			break;
		case "10":
			file = "input_2_10.txt";
			break;
		case "11":
			file = "input_2_11.txt";
			break;
		case "12":
			file = "input_2_12.txt";
			break;
		case "13":
			file = "input_2_13.txt";
			break;
		case "14":
			file = "input_2_14.txt";
			break;
		case "15":
			file = "input_2_15.txt";
			break;
		case "16":
			file = "input_2_16.txt";
			break;
		case "17":
			file = "input_2_17.txt";
			break;
		case "18":
			file = "input_2_18.txt";
			break;
		case "19":
			file = "input_2_19.txt";
			break;
		case "20":
			file = "input_2_20.txt";
			break;
		case "21":
			file = "input_2_21.txt";
			break;
		case "22":
			file = "input_2_22.txt";
			break;
		case "23":
			file = "input_2_23.txt";
			break;
		case "24":
			file = "input_2_24.txt";
			break;
		default:
			System.out.println("Default file default.txt choosen");
			file = "default.txt";
			break;
		}
		name = file;
		return file;
	}

	public static void quickSort(int[] arr, int p, int r) {
		if (p < r) {
			int q = partition(arr, p, r);
			quickSort(arr, p, q - 1);
			quickSort(arr, q + 1, r);
		}
	}

	public static int partition(int[] arr, int p, int r) {
		int x = arr[r];
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if (arr[j] <= x) {
				i = i + 1;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[r];
		arr[r] = temp;
		return i + 1;
	}

	public static void quickSort2(int[] arr, int p, int r) {

		if (p<r) {

			int N = (r-p+1);

			if (N <= cutoff) {
				insertionSort(arr);
				return;
			}

			int m = Median3(arr, p, p + (N/2), r);
			int temp = arr[m];
			arr[m] = arr[r];
			arr[r] = temp;
			int q =partition(arr, p, r);
			quickSort2(arr, p, q - 1);
			quickSort2(arr, q + 1, r);

		}
	}



	public static int Median3(int[] arr, int i, int j, int k) {
		if (arr[i] > arr[j] && arr[i] < arr[k] || arr[i] > arr[k]
				&& arr[i] < arr[j]) {
			return i;
		} else if (arr[j] > arr[i] && arr[j] < arr[k] || arr[j] > arr[k]
				&& arr[j] < arr[i]) {
			return j;
		} else if (arr[k] > arr[i] && arr[k] < arr[j] || arr[k] > arr[j]
				&& arr[k] < arr[i]) {
			return k;
		} else
			return i;
	}



	public static int cutOffVal() {
		System.out.println("Enter cutoff value for Quicksort with Median3: ");
		cutoff = StdIn.readInt();
		return cutoff;
	}

	public static void QckVsQckM3(){
		filePicker();
		int[] list = makeList();
		int[] list2 = Arrays.copyOf(list,list.length);
		//System.out.println("Is list sorted: " + sortCheckAsc(list2));
		cutOffVal();
		System.out.println("Preforming Quick Sort");

		long start = System.nanoTime();
		quickSort(list, 0, list.length - 1);
		long end = System.nanoTime();
		long time = end - start;

		System.out.println("Preforming Quick Sort w/Median3");
		long start2 = System.nanoTime();
		quickSort2(list2, 0, list2.length - 1);
		long end2 = System.nanoTime();
		long time2 = end2 - start2;
		//System.out.println(sortCheckAsc(list2));

		System.out.println("QuickSort took:   " + time);
		System.out.println("QuickSortM3 took: " + time2);

	}



	public static void main(String[] args) {
	}
}
