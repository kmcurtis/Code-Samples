import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;


public class DirectedGraph extends Graph{

	Vertex[] list;
	LinkedList<Vertex>[][] vList;


	@SuppressWarnings("unchecked")
	public DirectedGraph(BufferedReader reader) throws IOException {

		String line;
		line = reader.readLine();
		vList = new LinkedList[Integer.parseInt(line)][Integer.parseInt(line)];
		V = Integer.parseInt(line);
		list = new Vertex[V];
		line = reader.readLine();
		E = Integer.parseInt(line);
		adjM =  new LinkedList[V][V];

		for (int v = 0; v < V; v++) {
			for (int z = 0; z < V; z++) {

				adjM[v][z] = new LinkedList<Integer>();
				
			
				
					adjM[v][z].add(0);

				



			}
		}
		while ((line = reader.readLine()) != null) {
			String[] parse = line.split(" ");

			int tempV1, tempV2;
			//StringTokenizer st = new StringTokenizer(line, " ");
			tempV1 = Integer.parseInt(parse[0]);
			tempV2 = Integer.parseInt(parse[1]);
			addEdge(tempV1, tempV2);
		}
	}

	@Override
	public void addEdge(int v , int w){
		Vertex strt = new Vertex(v);
		Vertex dest = new Vertex(w);

		if(this.list[v] == null){
			list[v] = strt;
		}
		
		if(this.list[w] == null){
			list[w] = dest;
		}
		
		
		this.adjM[v][w].add(0,1);
		vList[v][w] = new LinkedList<Vertex>();

		this.vList[v][w].add(0,this.list[w]);

	}
	
	
	public void BFS(int x){
		Vertex s = this.list[x];


		for(int i = 0; i < this.vList.length; i++) {
			

				Vertex u = this.list[i];
				if(!u.equals(s)){
					u.setColor("WHITE");
					u.d = Integer.MAX_VALUE;
					u.π = null;
				}
			
				
		}
		s.setColor("GRAY");
		s.d = 0;
		s.π = null;

		LinkedList<Vertex> queue = new LinkedList<Vertex>();

		queue.add(s);
		while(queue.size() != 0) {
			Vertex uu = queue.pop();
			
			for(int q = 0; q < this.V; q++) {
				if(this.vList[uu.getData()][q] == null){
					continue;
				}
				for(Vertex v : this.vList[uu.getData()][q]){

				
//				if(this.vList[uu.getData()][q].get(0) != null){
//					Vertex v = this.list[q];



					if(v.getColor() == "WHITE") {
						v.setColor("GRAY");
						v.d = uu.d+1;
						v.π = uu;
						queue.add(v);
					}

				}
			}

			uu.setColor("BLACK");

		}


	}
	
	public void printPath(Vertex strt, Vertex dest) {

		if(strt == dest) {
			System.out.print(strt.getData()+" ");

		}
		else if(dest.π == null){
			System.out.println("No path from "+ strt.getData() +" to "+ dest.getData() +" exist\n");
		}
		else{
			printPath(strt, dest.π);
			if(dest.π.getData() == dest.getData()){
				return;
			}
			System.out.print(dest.getData()+" ");
		}
	}




	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("mediumG.txt"));
		DirectedGraph dg = new DirectedGraph(br);
		
		long start = System.nanoTime();
		dg.BFS(0);
		long end = System.nanoTime();

		
		Vertex source = dg.list[0];
		for(int i = 0; i < dg.V; i++) {

			Vertex dest = dg.list[i];
			System.out.println("Path from "+source.getData()+" to "+i+": ");
			dg.printPath(source, dest);
			System.out.println("\n");
		}
		long time = end - start;
		System.out.println("Search time of TinyDG.txt using adjacency matrix took "+time+"ns");
	


	}

}
