import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;




@SuppressWarnings("serial")
public class InitBoard extends JFrame {



	char input;
	int size = 50;
	


public JLabel[][] autoBoard(JLabel[][] board){
	
	
	

		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {

				board[i][j] = new JLabel();



				boolean setState = StdRandom.bernoulli();

				board[i][j].setSize(1, 1);
				board[i][j].setOpaque(true);
				board[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));




				if(setState == true) {
					board[i][j].setBackground(Color.BLACK);
					//b2[i][j].repaint();

				}
				else{
					board[i][j].setBackground(Color.WHITE);
					//b2[i][j].repaint();


				}
				this.add(board[i][j]);
				
			}

	}
	return board;
	
}



public JLabel[][] manualBoard(JLabel[][] board){
	
	for(int i = 0; i < size; i++) {
		for(int j = 0; j < size; j++) {

			board[i][j] = new JLabel();



			

			board[i][j].setSize(1, 1);
			board[i][j].addMouseListener(onClick);
			board[i][j].setOpaque(true);
			board[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));




			
				board[i][j].setBackground(Color.WHITE);


			
			this.add(board[i][j]);
		
			
		}

}

return board;

}


	public char getInput(){
		
		return StdIn.readChar();
	}

	public JLabel[][] InitialBoard() {
		System.out.println("Enter a number to make an N x N board :");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(size, size));

		JLabel[][] board = new JLabel[size][size];


		System.out.println("Manual Board 'M' or Automatic 'A'?");
		
		

         input = getInput();
        
        if(input == 'A'){
        	return autoBoard(board);
        }
        if(input == 'M'){
        	return manualBoard(board);
        }
		
		

		return null;



	}

	MouseListener onClick = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel label = (JLabel) e.getSource();
			if(label.getBackground().equals(Color.BLACK)){
				label.setBackground(Color.WHITE);
			}
			else {
				label.setBackground(Color.BLACK);

			}

			label.repaint();

		}
	};






	public static void main(String[] args) {


		InitBoard board = new InitBoard();
		board.setSize(800, 600);
		board.setVisible(true);




	}



}
