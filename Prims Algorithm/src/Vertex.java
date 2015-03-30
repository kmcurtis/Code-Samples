import java.util.ArrayList;


public class Vertex {


	Vertex π;
	double key;
	int d;
	int val;
	int weight;
	
	
	public Vertex(int v) {
		this.val = v;
		
		
	}
	
	public void setKey(int k) {
		this.key = k;
	}
	
	public double getKey() {
		return this.key;
	}
	
	public int getData() {
		return this.val;
	}
	
	public void setWeight(int t) {
		this.weight = t;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	
	


}
