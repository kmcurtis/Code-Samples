
public class GameOfLife extends UpdateBoard {
	
	public static void main(String[] args) {
		
		System.out.println("Enter a number to make an N x N board :");
		int size = StdIn.readInt();
		boolean[][] board = makeBoard(size);
		StdDraw.setScale(0, size);
		StdDraw.show(3);
		drawBoard(board);
		System.out.println(board.length);

		while(true){
			boardUpdate(board);
			drawBoard(board);
			StdDraw.show(30);
			StdDraw.clear();

		}
		
	}

}
