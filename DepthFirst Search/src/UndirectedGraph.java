import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;


public class UndirectedGraph extends Graph {

	ArrayList<Integer> grayList;
	LinkedList<Vertex>[][] vList;

	HashSet<Integer> inList;



	@SuppressWarnings("unchecked")
	public UndirectedGraph(BufferedReader reader) throws IOException {

		grayList = new ArrayList<Integer>();
		inList = new HashSet<Integer>();
		String line;
		line = reader.readLine();
		vList = new LinkedList[Integer.parseInt(line)][Integer.parseInt(line)];
		V = Integer.parseInt(line);
		line = reader.readLine();
		E = Integer.parseInt(line);
		adjM =  new LinkedList[V][V];
		Vertex zero = new Vertex(0);


		for (int v = 0; v < V; v++) {
			for (int z = 0; z < V; z++) {

				adjM[v][z] = new LinkedList<Integer>();
				vList[v][z] = new LinkedList<Vertex>();

				if(z == v){
					adjM[v][z].add(1);

				}
				else{
					adjM[v][z].add(0);

				}

				vList[v][z].add(zero);






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


		this.adjM[v][w].add(0,1);
		this.adjM[w][v].add(0,1);


		this.vList[v][v].add(0,strt);

		this.vList[w][w].add(0,dest);






		if(!this.inList.contains(v)) {

			this.inList.add(v);


		}
		this.vList[v][w].add(0,dest);
		this.vList[w][v].add(0,strt);



		if(!this.inList.contains(w)) {

			this.vList[w][v].add(dest);

			this.inList.add(w);


		}


	}

	public void BFS(){
		Vertex s = this.vList[0][0].get(0);


		for(int i = 0; i < this.vList.length; i++) {
			for(int j = 0; j < this.vList.length; j++) {

				Vertex u = this.vList[i][j].get(0);
				if(!u.equals(s)){
					u.setColor("WHITE");
					u.d = Integer.MAX_VALUE;
					u.π = null;
				}
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

				if(this.vList[uu.getData()][q].get(0) != null){
					Vertex v = this.vList[uu.getData()][q].get(0);



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

	public void printMatrix(UndirectedGraph ug){
		System.out.print("    ");

		for(int q = 0; q < ug.V; q++){
			System.out.print(q+" ");
		}
		System.out.println();
		System.out.print("    ");

		for(int q = 0; q < ug.V; q++){
			if(q> 9){
				System.out.print("_  ");

			}
			else{
				System.out.print("_ ");
			}
		}
		System.out.println();


		for(int i = 0; i < ug.V; i++){
			if(i<10){
				System.out.print(i+" | ");

			}
			else{
				System.out.print(i+"| ");
			}
			for(int j = 0; j < ug.V; j++){
				if(j >9){
					System.out.print(ug.adjM[i][j].get(0)+"  ");

				}
				else{
					System.out.print(ug.adjM[i][j].get(0)+" ");
				}
			}
			System.out.println();
		}

	}


	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader("mediumG.txt"));
		UndirectedGraph ug = new UndirectedGraph(bf);

		
		long start = System.nanoTime();

		ug.BFS();
		Vertex source = ug.vList[0][0].get(0);
		for(int i = 0; i < ug.V; i++) {

			Vertex dest = ug.vList[i][i].get(0);
			System.out.println("Path from "+source.getData()+" to "+i+": ");
			ug.printPath(source, dest);
			System.out.println("\n");
		}
		long end = System.nanoTime();
		long time = end - start;
		System.out.println("Search time of mediumG.txt using adjacency matrix took "+time+"ns");


		//System.out.println(ug.tostring());

	}







}
