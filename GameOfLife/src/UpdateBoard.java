import java.util.Arrays;


public class UpdateBoard extends InitBoard {

	private static boolean alive = true;

	public static boolean[][] boardUpdate(boolean[][] board) {
		boolean[][] boardCopy = Arrays.copyOf(board, board.length);

		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {

				int neighbors = countNeighbor( board,i,j);

				if(board[i][j] == alive){
					if(neighbors < 2){
						boardCopy[i][j] = false;
					}
					if(neighbors == 2 || neighbors == 3){

						boardCopy[i][j] = true;

					}
					if(neighbors > 3) {
						boardCopy[i][j] = false;
						
					}

				}
				
				if(board[i][j] != alive && neighbors == 3){
					boardCopy[i][j] = true;
				}


			}
		}
		return boardCopy;

	}

	public static int countNeighbor(boolean[][] board, int i, int j) {
		int count = 0;

		if(i+1 < board.length){
			if(board[i+1][j] == alive){
				count++;
			}
		}

		if(i-1 >= 0){
			if(board[i-1][j] == alive){
				count++;
			}
		}

		if(j+1 < board.length){
			if(board[i][j+1] == alive){
				count++;
			}
		}

		if(j-1 >= 0){
			if(board[i][j-1] == alive){
				count++;
			}
		}

		if(i+1 < board.length && j+1 < board.length){
			if(board[i+1][j+1] == alive){
				count++;
			}
		}

		if(i+1 < board.length && j-1 >= 0){
			if(board[i+1][j-1] == alive){
				count++;
			}
		}

		if(i-1 >= 0 && j+1 < board.length){
			if(board[i-1][j+1] == alive){
				count++;
			}
		}


		if(i-1 >= 0 && j-1 >= 0){
			if(board[i-1][j-1] == alive){
				count++;
			}
		}

		return count;

	}

}
