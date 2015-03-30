import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class InsSort {
	
	static String name = null;
	static int size;

	public static void printList(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}

	public static String filePicker(){
		String file =null;

		System.out.println("Choose a file to run Insertion Sort on by choosing from digits 1 to 9 to select the corresponding file: ");
		String num = StdIn.readString();

		switch(num){
		  case "1":
			file = "input1.txt";
			break;
		  case "2":
				file = "input2.txt";
				break;
		  case "3":
				file = "input3.txt";
				break;
		  case "4":
				file = "input4.txt";
				break;
		  case "5":
				file = "input5.txt";
				break;
		  case "6":
				file = "input6.txt";
				break;
		  case "7":
				file = "input7.txt";
				break;
		  case "8":
				file = "input8.txt";
				break;
		  case "9":
				file = "input9.txt";
				break;
		  default:
			  System.out.println("Default file input1.txt choosen");
			  file = "input1.txt";
			  break;		
		}
		name = file;
		return file;
	}
	public static int[] makeList(){

		ArrayList<Integer> list = new ArrayList<Integer>();
		String fileName = filePicker();
		File file = new File(fileName);
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
			size = list.size();


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
