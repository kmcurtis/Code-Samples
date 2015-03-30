import java.util.ArrayList;


public class PriorityQueue<T>  {

	private ArrayList<T> list;
	static int heapSize;

	
	public PriorityQueue() {
		list = new ArrayList<T>();
	}
	
	

	public static  int Left(int i){
		i = (2*i)+1;
		return i;
	}

	public static  int Right(int i){
		i = (2*i)+2;
		return i;
	}



	public  void buildMinHeap(ArrayList<T> list2){
		heapSize = list2.size()-1;
		for(int i = ((list2.size())/2); i >= 0; i--){
			minHeapify(list2,i);
		}		

	}

	public  void minHeapify(ArrayList<T> list2, int i){
		int smallest;

		int l = Left(i);
		int r = Right(i);



		if(l <= heapSize && list2.get(l).hashCode() < list2.get(i).hashCode()){
			smallest = l;
		}
		else{
			smallest = i;
		}
		if(r <= heapSize && list2.get(r).hashCode() < list2.get(smallest).hashCode()){
			smallest = r;
		}
		if(smallest != i){
			T temp = list2.get(i);
			list2.set(i, list2.get(smallest));
			list2.set(smallest, temp);
			minHeapify(list2, smallest);
		}
	}



	public int insert(T a){
		this.list.add( a);
		buildMinHeap(this.list);
		return this.list.indexOf(a);

	}

	public  boolean delete(T a){
		if(this.list.contains(a)){
			this.list.remove(a);
			buildMinHeap(this.list);
			if(!this.list.contains(a)){
				return true;
			}
		}
		return false;
	}
	
	public T getMin(){
		T element = this.list.get(0);
		this.list.set(0, this.list.get(this.list.size()-1));
		this.list.remove(this.list.size()-1);
		buildMinHeap(this.list);
		return element;
	}
	
	public int size(){
		return this.list.size();
	}
	
	public T peek(){
		return this.list.get(0);
	}
	
 	public String toString(){
		String lst = "";
		for(int i =0; i < this.list.size(); i++){
			lst = lst+String.valueOf(this.list.get(i))+" ";
		}
		return lst;
}

	public static void main(String[] args) {
		
		PriorityQueue<Integer> a = new PriorityQueue<Integer>();
	
		System.out.println("Inserting 1 9 56 -4 7 and 12");
		a.insert(1);
		a.insert(9);
		a.insert(56);
		a.insert(-4);
		a.insert(7);
		a.insert(-12);
		System.out.println(a.toString());

		a.getMin();
		System.out.println("Queue after getMin");

		System.out.println(a.toString());

		a.delete(1);
		System.out.println("Queue after deleting 1");
		System.out.println(a.toString());
		
		System.out.println();
		PriorityQueue<String> b = new PriorityQueue<String>();
		System.out.println("Inserting Z A X K S and Q");

		b.insert("Z");
		b.insert("A");
		b.insert("X");
		b.insert("K");
		b.insert("S");
		b.insert("Q");
		System.out.println(b.toString());

		b.getMin();
		System.out.println("Queue after getMin");
		System.out.println(b.toString());

		b.delete("S");
		System.out.println("Queue after deleting S");
		System.out.println(b.toString());
		


	}

}
