import java.util.HashMap;


public class Edge {
	
	Vertex dest;
	double weight;
	Vertex source;

	
	
	public Edge(Vertex s, Vertex d, double w) {
		this.source = s;
		this.dest = d;
		this.weight = w;
	}
	
	public void setVertex(Vertex d) {
		this.dest = d;
	}
	
	public Vertex getVertex(){
		return this.dest;
	}
	
	public void setWeight(double w){
		this.weight =w;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public void printEdge(){
		System.out.println(this.source.getData()+" "+this.dest.getData());
	}
	

}
