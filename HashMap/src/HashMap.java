
public class HashMap {

	final int mapsize = 100;
	HashElement[] map;
	public HashMap() {
		map = new HashElement[mapsize];

	}

	public HashMap(int size) {
		map = new HashElement[size];
	}

	public int hash(int k){

		int h = k%this.map.length;
		return h;
	}

	public int reHash(int k){

		int h = ((7*hash(k))+1)%this.map.length;

		if(this.map[h] != null && this.map[h].getKey() != k){
			return reHash(h);
		}
		else{
			return h;
		}
	}

	public void put(int k, String v){

		HashElement element = new HashElement(k, v);
		int position = hash(k);

		if(this.map[position] != null && this.map[position].getKey() == k) {

			this.map[position].setVal(v);

		}
		else{
			this.map[position] = element;
		}
	}

	public void get(int k) {
		int pos = hash(k);

		if(this.map[pos] == null){
			System.out.println("No item with key: "+k+" in the map");
		}
		else{
			System.out.println(this.map[pos].getVal());
		}
	}

	public void linearProbe(int k, String v) {

		HashElement element = new HashElement(k, v);
		int position = hash(k);
		int count =0;

		while(this.map[position] != null && this.map[position].getKey() != k) {

			count= count+1;
			position = ((hash(k)+count))%this.map.length;

		}

		this.map[position] = element;


	}


	public void linearGet(int k) {
		int pos = hash(k);
		int count = 0;

		while(this.map[(int) pos] != null && this.map[(int) pos].getKey() != k) {
			count= count+1;
			pos = ((hash(k)+count))%this.map.length;

		}
		if(count == this.map.length) {
			System.out.println("Element not found");
			return;
		}

		System.out.println(this.map[(int) pos].getVal());
	}

	public void quadraticProbe(int k, String v) {

		HashElement element = new HashElement(k, v);
		int position = hash(k);
		int count =1;

		while(this.map[position] != null) {

			

//			if(count % 2 == 0){
//				count = count + 1;
//			}

			position = ((hash(k)+count))%this.map.length;

//			if(position > this.map.length) {
//				System.out.println(position+"QQ");
//				//position = position - this.map.length;
//			}
			count= count+2;

		}

		this.map[position] = element;


	}

	public void quadraticGet(int k) {
		int pos = hash(k);
		int count = 1;
		

		while(this.map[pos] != null && this.map[pos].getKey() != k) {
		

		
			pos = ((hash(k)+count))%this.map.length;
			count= count+1;


		}
		if( this.map[pos] == null) {
			System.out.println("Element not found");
			return;
		}
		System.out.println(this.map[pos].getVal());
	}

	public boolean isFull(){
		for(int i = 0; i < this.map.length; i++) {
			if(this.map[i] != null) {
				continue;
			}
			else{ 
				return false;
			}

		}
		return true;
	}



	public String toString() {
		String line = "";
		for(int i =0; i < this.map.length; i++){ 
			if(this.map[i] != null){
				line+=this.map[i].getVal() +" ";
			}
			else
			{
				line += "null ";
			}
		}
		return line;
	}

	public void put(float k, String v) {
		HashElement element = new HashElement(k, v);
		float position = hash(k);

		if(this.map[(int) position] != null && this.map[(int) position].getKey() == k) {

			this.map[(int) position].setVal(v);

		}
		else{
			this.map[(int) position] = element;
		}

	}

	private int hash(float k) {
		int h = (int) (k%this.map.length);
		return (int)h;

	}

	public void linearProbe(float k, String v) {
		HashElement element = new HashElement(k, v);
		float position = hash(k);
		int count =0;

		while(this.map[(int) position] != null && this.map[(int) position].getKey() != k) {

			count= count+1;
			position = ((hash(k)+count))%this.map.length;

		}

		this.map[(int) position] = element;
	}




	public void quadraticProbe(float k, String v) {
		HashElement element = new HashElement(k, v);
		int position = hash(k);
		int count =1;

		while(this.map[ (int) position] != null && this.map[(int) position].getKey() != k) {

			
			
			position = ((hash(k)+count))%this.map.length;
			count= count+2;

		}

		this.map[(int) position] = element;

	}

}
