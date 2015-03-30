import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class WeightedGraph extends Graph {

	Vertex[] vList;
	Edge weightEdge;
	LinkedList<Edge>[] adj;
	ArrayList<Integer> found = new ArrayList<Integer>();
	int count = 0;
	ArrayList<Double> done = new ArrayList<Double>();
	HashMap<Double, Integer> weightC = new HashMap<Double, Integer>();



	public WeightedGraph(BufferedReader reader) throws IOException {
		String line;
		line = reader.readLine();
		V = Integer.parseInt(line);
		vList = new Vertex[V];
		line = reader.readLine();
		E = Integer.parseInt(line);
		adj =  new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Edge>();
		}
		while ((line = reader.readLine()) != null) {
			int tempV1, tempV2;
			double tempV3;
			StringTokenizer st = new StringTokenizer(line, " ");
			tempV1 = Integer.parseInt(st.nextToken());
			tempV2 = Integer.parseInt(st.nextToken());
			tempV3 = Double.parseDouble(st.nextToken());

			addEdge(tempV1, tempV2, tempV3);
		}
	}

	public boolean weightCount(double w){
		if(weightC.get(w) > 1){
			return true;
		}

		return false;
	}

	public void addEdge(int s, int e, double w){

		Vertex strt = new Vertex(s);
		Vertex dest = new Vertex(e);

		if(this.vList[s] == null){
			this.vList[s] = strt;
		}

		if(this.vList[e] == null){
			this.vList[e] = dest;
		}
		Edge egde = new Edge(this.vList[s],this.vList[e], w);

		this.adj[s].add(egde);

		Edge egde2 = new Edge(this.vList[e],this.vList[s], w);


		this.adj[e].add(egde2);
		if(!weightC.containsKey(w)){
			weightC.put(w, 1);
		}
		else{
			weightC.put(w, weightC.get(w)+1);
		}


	}


	public void Prim(Vertex r){

		LinkedList<Vertex> queue = new LinkedList<Vertex>();

		for(int i = 0; i < this.vList.length; i++) {
			this.vList[i].setKey(Integer.MAX_VALUE);
			this.vList[i].π = null;

			queue.add(this.vList[i]);
		}
		r.setKey(0);
		found.add(r.getData());

		while(!queue.isEmpty()) {
			int vertNum = ExtractMin(found);
			Vertex u = this.vList[vertNum];
			found.add(u.getData());
			queue.remove();


		}

	}

	public int ExtractMin(ArrayList<Integer> edges) {

		double small = Integer.MAX_VALUE;
		Edge edge = null;
		int index = 0;

		for(Integer v : edges){
			for(Edge e : this.adj[v]){
				if(e.weight < small && !this.done.contains(e.weight) && !this.found.contains(e.getVertex().getData())){
					small = e.weight;
					index = e.getVertex().getData();
					edge = e;

				}
				if(this.weightCount(e.weight) == true && !this.found.contains(e.getVertex().getData())){
					small = e.weight;
					index = e.getVertex().getData();
					edge = e;

				}

			}
		}
		if(small != Integer.MAX_VALUE){
			this.done.add(small);
		}

		count++;

		if(small != Integer.MAX_VALUE){
			edge.printEdge();
		}


		return index;

	}

	@Override
	public String tostring()
	{
		String s = new String();
		System.out.println("There are "+V+" vertices and "+E+" edges\n");
		for(int i=0;i<V;i++)
		{

			System.out.print(i+": ");
			for(int j = 0; j<adj[i].size();j++)
			{

				System.out.print(adj[i].get(j).getVertex().getData()+"|"+adj[i].get(j).getWeight()+" ");
			}
			System.out.println();
		}
		return s;
	}




}
