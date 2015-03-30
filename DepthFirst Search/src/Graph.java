
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;



public class Graph {
	public int V;
	public int E;

	public LinkedList<Integer>[][] adjM;

	public Graph()
	{
		V = 0;
		E = 0;
	}

	public Graph(BufferedReader reader) throws IOException
	{
		String line;
		line = reader.readLine();
		V = Integer.parseInt(line);
		line = reader.readLine();
		E = Integer.parseInt(line);
		adjM =  new LinkedList[V][V];
		for (int v = 0; v < V; v++) {
			for (int i = 0; i < V; i++) {


				adjM[v][i] = new LinkedList<Integer>();
				adjM[v][i].add(0);
			}
		}
		while ((line = reader.readLine()) != null) {
			int tempV1, tempV2;
			StringTokenizer st = new StringTokenizer(line, " ");
			tempV1 = Integer.parseInt(st.nextToken());
			tempV2 = Integer.parseInt(st.nextToken());
			addEdge(tempV1, tempV2);
		}
	}


	public void addEdge(int v, int w) {
		this.adjM[v][w].add(0,1);

	}

	public String tostring()
	{
		String s = new String();
		s = "There are "+V+" vertices and "+E+" edges\n";
		for(int i = 0; i<V; i++)
		{
			s = s+i+": ";

			for(int j = 0; j<V;j++){

				if(adjM[i][j].get(0) == 1){
					
				
				s = s+j+" ";

				//s = s;
				}
			}
			s +="\n";


		}
		return s;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("LargeG.txt"));

		Graph g = new Graph(br);
		System.out.print("    ");

		for(int q = 0; q < g.V; q++){
			System.out.print(q+" ");
		}
		System.out.println();
		System.out.print("    ");

		for(int q = 0; q < g.V; q++){
			if(q> 9){
				System.out.print("_  ");

			}
			else{
				System.out.print("_ ");
			}
		}
		System.out.println();


		for(int i = 0; i < g.V; i++){
			if(i<10){
				System.out.print(i+" | ");

			}
			else{
				System.out.print(i+"| ");
			}
			for(int j = 0; j < g.V; j++){
				if(j >9){
					System.out.print(g.adjM[i][j].get(0)+"  ");

				}
				else{
					System.out.print(g.adjM[i][j].get(0)+" ");
				}
			}
			System.out.println();
		}

		System.out.print(g.tostring());
	}

}