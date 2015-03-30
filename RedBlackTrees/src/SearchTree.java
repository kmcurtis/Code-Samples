public class SearchTree<T extends Comparable<T>> extends RBTree<T> {


	public void sSearch(String k) {

		RBNode<T> it =  (RBNode<T>) this.root;
		

		while(true) {
			
			if (it != null) {
				

			
				if (Double.parseDouble(it.getData().toString()) == Double.parseDouble(k)) {
					System.out.println("FOUND "+it.getData());
					return;
					//it.getData().toString();
				}

				
				else if ( Double.parseDouble(it.getData().toString()) < Double.parseDouble(k) ) {
				
					it = (RBNode<T>) it.getRight();
					
					
				} 
				else {

					it = (RBNode<T>) it.getLeft();
				}
			} 
			else {
				 break;
			}
		}
	}
}
