import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class SearchDriver {

	public static void main(String[] args) {
		SearchTree<String> tree = new SearchTree<String>();
		File file = new File("/home/marquez/Desktop/UPC.csv");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			line = br.readLine();
			while(line != null){
				
				String[] array = line.split(",");
				tree.Insert(new RBNode<String>(array[0],array[2]));
				line = br.readLine();
				
				
				
				
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File keys = new File("/home/marquez/Desktop/input.dat");
		try {
			
			Scanner scan = new Scanner(keys);
			String line2 = "";
			long time = 0;
			while(scan.hasNext()){
				line2  = scan.nextLine();
				
				String[] a = line2.split("\\n");
				int n = Integer.parseInt(a[0]);
				
				long start = System.nanoTime();
				tree.sSearch(String.valueOf(n));
				long end = System.nanoTime();
				time =+ (end - start);
				
				
				
			
			
				
				
			}
			scan.close();
			System.out.println("Search took "+time+"ns");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	
}
