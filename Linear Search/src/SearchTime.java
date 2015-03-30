import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SearchTime extends Search {

	private static File input = null;
	private static int[] numList = null;
	private static int key;

	/*Method that allows user to pick input file for Linear Search */
	public static void pickFile(){
		System.out.println("Pick a file size to run Linear and Binary Search on: 100, 1000, or 10000");
		String choice = StdIn.readString();

		switch (choice){
		case "100": 
			numList = new int[100];
			input = new File("input100.txt");
			break;

		case "1000": 
			numList = new int[1000];
			input = new File("input1000.txt");
			break;


		case "10000": 
			numList = new int[10000];
			input = new File("input10000.txt");
			break;


		default : 
			numList = new int[0];
			System.out.println("Incorrect size choosen, exception will be thrown");
			break;
		}

	}

	

	/*Method that prompts user for search key*/
	public static int pickKey(){
		System.out.println("Input a number to search for:");
		key = StdIn.readInt();
		return key;
	}

	/*Runs Linear Search and computes execution time*/
	public static void linearTime(){

		try {
			Scanner scan = new Scanner(input);
			for(int i = 0; i < numList.length; i++){
				numList[i] = scan.nextInt();
			}
			scan.close();
			long start = System.nanoTime();
			System.out.println(linearSer(numList, key));
			long end = System.nanoTime();
			long time = end-start;
			System.out.println("Linear Seacrh on input size "+numList.length+ " took "+time+"ns");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*Runs Binary Search and computes execution time*/

	public static void binaryTime(){


		try {
			Scanner scan = new Scanner(input);
			for(int i = 0; i < numList.length; i++){
				numList[i] = scan.nextInt();
			}
			scan.close();
			long start = System.nanoTime();
			System.out.println(binarySearch(numList,key, 0, numList.length-1));
			long end = System.nanoTime();
			long time = end-start;
			System.out.println("Binary search on input size "+numList.length+" took "+time+  "ns");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
