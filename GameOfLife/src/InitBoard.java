


public class InitBoard {

	public static boolean[][] makeBoard(int n) {
		boolean[][] board = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = StdRandom.bernoulli();
			}
		}
		return board;
	}

	public static void drawBoard(boolean[][] b) {
		for(int i = 0; i < b.length; i++) {
			for(int j  = 0; j < b.length; j++) {

				if(b[i][j] == true) {
					StdDraw.filledSquare(i, j, .50);

				}
				else{
					StdDraw.square(i, j, .50);

				}
			}
		}
	}

	

}
