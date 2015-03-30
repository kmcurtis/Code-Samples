import java.util.ArrayList;


public class SortDriver extends Sort {

	
	public static void main(String[] args) {


		ArrayList<DesTime> list = makeList();
		destSort(list);
	

		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i).toString());
		}
	}

}
