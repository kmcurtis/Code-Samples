import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class GraphDriver {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("TinyDG.txt"));
		DirectedGraph dg = new DirectedGraph(br);

		dg.TopSort();



	}

}
