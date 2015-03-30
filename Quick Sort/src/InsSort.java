import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class InsSort extends FileReadSortCheck {
	
	public static void printList(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	public static int[] makeList(){

		ArrayList<Integer> list = new ArrayList<Integer>();
		File file = new File("input1.txt");
		int[] arr = null;

		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNext()){
				list.add(scan.nextInt());
				if(scan.hasNext() == false){
					break;
				}
			}
			scan.close();
			arr = new int[list.size()];
			for(int i = 0; i < list.size(); i++){
				arr[i] = list.get(i);
			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}

	public static int[] insertionSort(int[] arr){
		int i;
		int key;

		for(int j = 1; j < arr.length; j++){
			key = arr[j];
			i = j-1;
			while(i >= 0 && arr[i] > key){
				arr[i+1] = arr[i];
				i = i-1;
			}
			arr[i+1]=key;
		}
		return arr;
	}


}
