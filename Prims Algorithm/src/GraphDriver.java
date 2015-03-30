import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class GraphDriver {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("LargeGraph.txt"));
		WeightedGraph wg = new WeightedGraph(br);

		long start = System.nanoTime();
		wg.Prim(wg.vList[1]);
		long end = System.nanoTime();
		long time = end-start;

		System.out.println("Prim's Algorithm took "+time+"ns");

	}

}
