
public class HashElement {

	int key;
	float key2;
	String value;
	
	
	public HashElement(int x, String data) {
		
		key = x;
		value = data;
	}
	
	public HashElement(float x, String data) {
		
		key2 = x;
		value = data;
	}
	
	public String getVal() {
		return this.value;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public void setVal(String v) {
		value = v;
	}


}
