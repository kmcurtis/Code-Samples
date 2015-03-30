import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;


public class DirectedGraph extends Graph{

	Vertex[] list;
	LinkedList<Vertex>[] vList;
	int time;
	LinkedList<Integer> topList;


	@SuppressWarnings("unchecked")
	public DirectedGraph(BufferedReader reader) throws IOException {


		topList = new LinkedList<Integer>();
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
			this.list[v] = strt;
			this.vList[v] = new LinkedList<Vertex>();

		}

		if(this.list[w] == null){
			this.list[w] = dest;
		}

		this.adj[v].add(w);




		if(this.vList[v] == null){
			this.vList[v] = new LinkedList<Vertex>();
		}
		this.vList[v].add(this.list[w]);





	}



	


	public void DFS(){
		for(int i = 0; i < this.V; i++) {
			this.list[i].setColor("WHITE");

			this.list[i].π = null;
			

		}

		time = 0;
		for(int i = 0; i < this.V; i++) {
			Vertex u = this.list[i];
			if(this.list[i].getColor()=="WHITE"){
				this.dfsVisit(this.list[i]);
			}

		}

	}

	public void dfsVisit(Vertex u) {
		time = time+1;
		u.d = time;
		u.setColor("GRAY");
		if(this.vList[u.getData()] != null){
			for(Vertex v : this.vList[u.getData()]) {
				if(v.getColor() == "WHITE") {
					v.π = u;
					this.dfsVisit(v);
				}
			}
		}
		this.topList.push(u.getData());
		u.setColor("BLACK");
		time = time+1;
		u.finish = time;



	}



	public void TopSort(){
		this.DFS();
		for(int i = 0; i < this.V; i++){
			System.out.print(this.topList.pop()+" ");
		}
	}


	

}
