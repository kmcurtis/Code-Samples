import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class HeapSort extends MrgSort {
static int heapSize;
static String name;
static int fileSize = 0;

public static boolean sortCheckAsc(int[] a) {
    int  N = a.length;
    int prev = a[0];
    boolean isSorted = true;
    for(int i=1; i< N; i++){
        if(a[i] >= prev) {
            continue;
        }
        else {
            isSorted = false;
            return isSorted;
        }
    }
    return isSorted;
}    

public static  void printList(int[] arr){
	for(int i =0; i < arr.length; i++){
		System.out.print(arr[i]+" ");
	}
}

public static  int Left(int i){
	i = (2*i);
	return i;
}

public static  int Right(int i){
	i = (2*i)+1;
	return i;
}

	public static void heapSort(int[] arr){
		buildMaxHeap(arr);
		for(int i = arr.length-1; i >0; i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapSize = heapSize-1;
			maxHeapify(arr, 0);
		}
	}
	
	public static void buildMaxHeap(int[] arr){
		heapSize = arr.length-1;
		for(int i = ((arr.length)/2); i >= 0; i--){
			maxHeapify(arr,i);
		}		
		
	}
	
	public static void maxHeapify(int[] arr, int i){
		int largest;

		int l = Left(i);
		int r = Right(i);
		

		
		if(l <= heapSize && arr[l] > arr[i]){
			largest = l;
		}
		else{
			largest = i;
		}
		if(r <= heapSize && arr[r] > arr[largest]){
			largest = r;
		}
		if(largest != i){
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			maxHeapify(arr, largest);
		}
	}
	
	public static int[] makeList(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] newList = null;
		File file = new File(name);
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextInt()){
				list.add(scan.nextInt());
			}
			scan.close();
			fileSize = list.size();
			newList = new int[list.size()];
			for(int i = 0; i < list.size(); i++){
				newList[i] = list.get(i);
			}
			System.out.println("List size is "+newList.length);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newList;

	}

	//Method that prompts user for a number that corresponds to the input file
	public static String filePicker(){
		String file =null;

		System.out.println("Choose a file to run Heap Sort on by entering one of the numbers from to select the corresponding file: ");
		System.out.println("File Number List: Pick a number ranging from 4 - 24");
		String num = StdIn.readString();

		switch(num){
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
	

}
