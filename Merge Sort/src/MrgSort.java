import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class MrgSort extends InsSort {

	static String name  = null;
	static int fileSize = 0;
	static int cutOff = 0;

	public static void cutOffNum(){
		System.out.println("Enter cut off value for Merge Sort w/ Insertion Sort: ");
		cutOff = StdIn.readInt();
		System.out.println(cutOff);
	}

	public static void mergeSort(int[] arr, int[] temp, int p, int r){

		if(p<r){
			int q =(p+r)/2;
			mergeSort(arr, temp, p, q);
			mergeSort(arr, temp, q+1, r);
			merge(arr,temp,p,q,r);
		}
	}

	public static void mergeSort2(int[] arr, int[] temp, int p, int r){

		if(r > p){

			int q =(p+r)/2;

			if(r <= cutOff || q <= cutOff ){
				insertionSort(arr);

			}
			else{



				mergeSort2(arr, temp, p, q);
				mergeSort2(arr, temp, q+1, r);
				merge2(arr,temp,p,q,r);
			}
		}
		else
			return;


	}

	public static void merge(int[] arr, int[] temp, int p, int q, int r){
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

	public static void merge2(int[] arr, int[] temp, int p, int q, int r){
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


	public static void mergComp(){
		filePicker();
		int[] test = makeList();
		int[] test2 = new int[test.length];

		int[] temp = Arrays.copyOf(test,test.length);
		int[] temp2 = new int [temp.length];



		long start2 = System.nanoTime();
		mergeSort2(test2, temp2, 0, test2.length-1);
		long end2 = System.nanoTime();
		long time2 = end2-start2;
		System.out.println("Execution time of Merge Sort with Insertion Sort on file " + name+" with "+fileSize+" elements took "+ time2+"ns");
		

		long start = System.nanoTime();
		mergeSort(test, temp, 0, test.length-1);
		long end = System.nanoTime();
		long time = end-start;
		System.out.println("Execution time of Merge Sort on file " + name+" with "+fileSize+" elements took "+ time+"ns");


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

		System.out.println("Choose a file to run Merge Sort on by entering one of the numbers from to select the corresponding file: ");
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

	public static void compareTime(){
		filePicker();
		int[] origi = makeList();
		int[] temp = Arrays.copyOf(origi,origi.length);
		int[] arr2 = Arrays.copyOf(origi,origi.length);


		long start = System.nanoTime();
		insertionSort(arr2);
		long end = System.nanoTime();
		long time = end-start;
		System.out.println("Execution time of Insertion Sort on file " + name+" with "+fileSize+" elements took "+ time+"ns");


		long start2 = System.nanoTime();
		mergeSort(origi, temp, 0, origi.length-1);
		long end2 = System.nanoTime();
		long time2 = end2-start2;
		System.out.println("Execution time of Merge Sort on file " + name+" with "+fileSize+" elements took "+ time2+"ns");

	}

	public static void printList(int[] arr){
		for(int i =0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}


}
