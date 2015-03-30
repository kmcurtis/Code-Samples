import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;


public class UndirectedGraph extends Graph {

	ArrayList<Integer> grayList;
	LinkedList<Vertex>[] vList;
	LinkedList<Vertex> topList;

	Vertex[] list;
	int time;

	HashSet<Integer> inList;
	HashSet<Integer> inList2;




	@SuppressWarnings("unchecked")
	public UndirectedGraph(BufferedReader reader) throws IOException {

		grayList = new ArrayList<Integer>();
		topList = new LinkedList<Vertex>();

		inList = new HashSet<Integer>();
		inList2 = new HashSet<Integer>();

		String line;
		line = reader.readLine();
		vList = new LinkedList[Integer.parseInt(line)];
		V = Integer.parseInt(line);
		list = new Vertex[V];
		line = reader.readLine();
		E = Integer.parseInt(line);
		adj =  new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Integer>();
			vList[v] = new LinkedList<Vertex>();
		}
		while ((line = reader.readLine()) != null) {
			String[] parse = line.split(" ");

			int tempV1, tempV2;
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
			this.list[v] = strt;
		}
		
		if(this.list[w] == null){
			this.list[w] = dest;
		}
		this.adj[v].add(w);
		this.adj[w].add(v);

	

		this.vList[v].add(this.list[w]);
		this.vList[w].add(this.list[v]);





	}

	public void BFS(){
		Vertex s = this.list[0];
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
			for(Vertex v : this.vList[uu.getData()]) {


				if(v.getColor() == "WHITE") {
					v.setColor("GRAY");
					v.d = uu.d+1;
					v.π = uu;
					queue.add(v);
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

	
	public void DFS(){
		for(int i = 0; i < this.vList.length; i++) {
			Vertex u = this.list[i];

			u.setColor("WHITE");
			u.π = null;

		}

		time = 0;
		for(int i = 0; i < this.vList.length; i++) {
			Vertex u = this.list[i];
			if(u.getColor()=="WHITE"){
				dfsVisit(u);
			}

		}

	}

	public void dfsVisit(Vertex u) {
		time = time+1;
		u.d = time;
		u.setColor("GREY");
		for(Vertex v : this.vList[u.getData()]) {
			if(v.getColor() == "WHITE") {
				v.π = u;
				dfsVisit(v);
			}
		}
		this.topList.push(u);
		u.setColor("BLACK");
		time = time+1;
		u.finish = time;



	}
	
	public void TopSort(){
		this.DFS();
	}

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader("smallG.txt"));
		UndirectedGraph ug = new UndirectedGraph(bf);

		
		long start = System.nanoTime();
		ug.DFS();

		
		Vertex source = ug.list[0];
		for(int i = 0; i < ug.V; i++) {
			Vertex dest = ug.list[i];
			System.out.println("Path from "+source.getData()+" to "+i+": ");
			ug.printPath(source, dest);
			System.out.println("\n");
		}
		
	
		





	}

}
