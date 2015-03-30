

import javax.swing.*;

public class Board {

	public void createWindow(){
	JFrame frame = new JFrame("window");
	JPanel panel = new JPanel();
	JMenuBar mBar = new JMenuBar();
	JMenuItem fileItem = new JMenuItem("File");
	ImageIcon icon = new ImageIcon("wcircle.jpg");

	JLabel label = new JLabel(icon);


	frame.setSize(800, 600);
	panel.setSize(800, 600);
	

	mBar.add(fileItem);
	panel.add(mBar);
	panel.add(label);
	label.setSize(50, 50);

	frame.add(panel);
	
	frame.setVisible(true);
	}
	
	public static void main(String[] args) {

		Board b = new Board();
		b.createWindow();
		
	}

}
