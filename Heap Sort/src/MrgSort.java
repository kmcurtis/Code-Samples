import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class MrgSort extends InsSort {
	
	static String name  = null;

	public static void mergeSort(int[] arr, int[] temp, int p, int r){

		if(p<r){
			int q =(p+r)/2;
			mergeSort(arr, temp, p, q);
			mergeSort(arr, temp, q+1, r);
			merge(arr,temp,p,q,r);
		}
	}

	public static void merge(int[] arr, int[] temp, int p, int q, int r ){
		int i = p;
		int j = q+1;

		for(int k = p; k<=r; k++){
			temp[k] = arr[k];
		}

		for(int k = p; k <=r; k++){
			if(i > q){
				arr[k] = temp[j];
				j=j+1;
			}
			else if(j >r){
				arr[k]=temp[i];
				i=i+1;
			}
			else if(temp[j] < temp[i]){
				arr[k]=temp[j];
				j=j+1;
			}
			else{
				arr[k]=temp[i];
				i=i+1;
			}


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

		System.out.println("Choose a file to run Merge Sort on by entering one of the numbers from to select the corresponding file: ");
		System.out.println("File Number List: 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192");
		String num = StdIn.readString();

		switch(num){
		  case "16":
			file = "input_16.txt";
			break;
		  case "32":
				file = "input_32.txt";
				break;
		  case "64":
				file = "input_64.txt";
				break;
		  case "128":
				file = "input_128.txt";
				break;
		  case "256":
				file = "input_256.txt";
				break;
		  case "512":
				file = "input_512.txt";
				break;
		  case "1024":
				file = "input_1024.txt";
				break;
		  case "2048":
				file = "input_2048.txt";
				break;
		  case "4096":
				file = "input_4096.txt";
				break;
		  case "8192":
				file = "input_8192.txt";
				break;
		  default:
			  System.out.println("Default file input_16.txt choosen");
			  file = "input_16.txt";
			  break;		
		}
		name = file;
		return file;
	}
	
	public static void printList(int[] arr){
		for(int i =0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	

}
