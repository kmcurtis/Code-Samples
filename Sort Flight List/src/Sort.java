import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class Sort {
	
static int size;
	

	
	
	public static ArrayList<DesTime> timeSort(ArrayList<DesTime> list){
		int i;
		DesTime key;

		for(int j = 1; j < list.size(); j++){
			key = list.get(j);
			i = j-1;

			while(i >= 0 && list.get(i).time2Num() > key.time2Num()){
				list.set(i+1, list.get(i));
				i = i-1;
			}
			list.set(i+1, key);
		}
		return list;
	}
	
	public static ArrayList<DesTime> destSort(ArrayList<DesTime> list){
		int i;
		DesTime key;

		for(int j = 1; j < list.size(); j++){
			key = list.get(j);
			i = j-1;

			while(i >= 0 && list.get(i).getDes().compareTo(key.getDes()) >0 ){
				list.set(i+1, list.get(i));
				i = i-1;
			}
			list.set(i+1, key);
		}
		return list;
	}
	
	


	
	public  static ArrayList<DesTime> newBucketSort(ArrayList<DesTime> arr){
		ArrayList<DesTime>[] list = new ArrayList[arr.size()];
		int n = arr.size();

		for(int i = 0; i < n; i++){
			list[i] = new ArrayList<DesTime>();
		}

		for(int i = 0; i < n; i++){
			list[(int) ((arr.get(i)).time2Num()*.00001)].add(arr.get(i));
		}


		for(int i = 0; i < n; i++){


			timeSort(list[i]);
		}

		ArrayList sorted = new ArrayList();
		for(int i = 0; i < n; i++){
			if(list[i] != null){
				for(int j = 0; j< list[i].size(); j++){
					sorted.add(list[i].get(j));
				}
			}

		}
		return sorted;
		
	}


	

	
	public static ArrayList<DesTime> makeList(){

		ArrayList<DesTime> list = new ArrayList<DesTime>();
		
		File file = new File("Log.txt");
		int[] arr = null;

		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNext()){
				String[] pieces = new String[2];
				pieces[0] = scan.next();
				pieces[1] = scan.next();
				list.add(new DesTime(pieces[0], pieces[1]));
				if(scan.hasNext() == false){
					break;
				}
			}
			scan.close();
			size = list.size();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	

}
