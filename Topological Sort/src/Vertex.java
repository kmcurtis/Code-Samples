import java.util.ArrayList;


public class Vertex {


	Vertex π;
	String color;
	int d;
	int val;
	int finish;
	protected ArrayList<Vertex> edges;
	
	
	public Vertex(int v) {
		this.val = v;
		edges = new ArrayList<Vertex>();
		
		
	}
	
	public void setColor(String c) {
		this.color = c;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getData() {
		return this.val;
	}
	
	public void setFinish(int t) {
		this.finish = t;
	}
	
	public int getFinisg() {
		return this.finish;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
