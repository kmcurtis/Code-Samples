
public class DesTime {

	String des = "";
	String time;
	public DesTime(String place, String tme) {
		des = place;
		time = tme;
			}
	
	@Override
	public String toString(){
		
		return this.des+" "+this.time;
	}
	
	public String getTime(){
		return this.time;
	}
	
	public String getDes(){
		return this.des;
	}
	
	public int time2Num(){
		String[] a = new String[3];
		a = this.getTime().split(":");
		String num = a[0]+a[1]+a[2];
		int val = Integer.parseInt(num);
		return val;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
