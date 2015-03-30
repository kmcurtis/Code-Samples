import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOfLife extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void Quit(){
		System.exit(ABORT);
	}

	public static void manualPlay(JLabel[][] board){
		System.out.println("Press S to start");
		while(true){
			if(StdIn.readChar() == 'S'){
				break;
			}
			
		}
		System.out.println("Press D to quit");
		while(true){
			if(StdIn.readChar() == 'D'){
				Quit();
			}
			UpdateBoard.boardUpdate(board);
			try {
				Thread.sleep(100);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

		}

	}

	public static void autoPLay(JLabel[][] board){
		System.out.println("Press DD to quit");
		
		while(true){
			if(StdIn.readChar() == 'D'){
				Quit();
			}
			UpdateBoard.boardUpdate(board);
			try {
				Thread.sleep(100);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

		}

	}

	public static void main(String[] args) throws InterruptedException {


		InitBoard board = new InitBoard();
		JLabel[][] bb = board.InitialBoard();
		board.setSize(800, 600);
		board.setVisible(true);

		System.out.println("When Done Press 'D' ");

		if(board.input == 'A'){
			autoPLay(bb);
		}

		if(board.input == 'M'){
			
			manualPlay(bb);
		}


	}

}
