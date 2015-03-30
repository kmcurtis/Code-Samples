import java.awt.Color;
import java.util.Arrays;

import javax.swing.JLabel;


public class UpdateBoard  {



	
	private static Color alive = Color.BLACK;
	private static Color dead = Color.WHITE;


	public static JLabel[][] boardUpdate(JLabel[][] board) {
		JLabel[][] boardCopy = Arrays.copyOf(board, board.length);

		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {

				int neighbors = countNeighbor( board,i,j);

				if(board[i][j].getBackground().equals(alive)){
					if(neighbors < 2){
						boardCopy[i][j].setBackground(dead);
						continue;
					}
					
					if(neighbors == 2 || neighbors == 3){

						continue;


					}
					if(neighbors > 3) {
						boardCopy[i][j].setBackground(dead);
						continue;

						
					}
					

				}
				
				if(board[i][j].getBackground().equals(dead) && neighbors == 3){
					boardCopy[i][j].setBackground(alive);
					continue;

				}

			}
		}
		return boardCopy;

	}

	public static int countNeighbor(JLabel[][] board, int i, int j) {
		int count = 0;

		if(i+1 < board.length){
			if(board[i+1][j].getBackground().equals(alive)){
				count++;
			}
		}

		if(i-1 >= 0){
			if(board[i-1][j].getBackground().equals(alive)){
				count++;
			}
		}

		if(j+1 < board.length){
			if(board[i][j+1].getBackground().equals(alive)){
				count++;
			}
		}

		if(j-1 >= 0){
			if(board[i][j-1].getBackground().equals(alive)){
				count++;
			}
		}

		if(i+1 < board.length && j+1 < board.length){
			if(board[i+1][j+1].getBackground().equals(alive)){
				count++;
			}
		}

		if(i+1 < board.length && j-1 >= 0){
			if(board[i+1][j-1].getBackground().equals(alive)){
				count++;
			}
		}

		if(i-1 >= 0 && j+1 < board.length){
			if(board[i-1][j+1].getBackground().equals(alive)){
				count++;
			}
		}


		if(i-1 >= 0 && j-1 >= 0){
			if(board[i-1][j-1].getBackground().equals(alive)){
				count++;
			}
		}

		return count;

	}

}
