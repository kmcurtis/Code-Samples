import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashDriver extends HashMap {

	public static void main(String[] args) {

		File file = new File("UPC.csv");
		HashMap map = new HashMap(12001);
		HashMap mapL = new HashMap(12001);
		HashMap mapQ = new HashMap(12001);

		try {
			Scanner scan = new Scanner(file);
			int count = 0;
			while (scan.hasNext()) {

				String[] line = scan.nextLine().split(",");
				count++;
				if (count == 12000) {
					break;
				}

				// map.put(Integer.parseInt(line[0]), line[2]);
				// mapL.linearProbe(Integer.parseInt(line[0]), line[2]);

				mapQ.quadraticProbe(Integer.parseInt(line[0]), line[2]);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File file2 = new File("input.dat");

		long start = System.nanoTime();
		try {
			Scanner sc = new Scanner(file2);
			while (sc.hasNext()) {
				int key = sc.nextInt();

				// map.get(key);
				// mapL.linearGet(key);

				mapQ.quadraticGet(key);

			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.nanoTime();

		System.out.println(end - start);

	}

}
