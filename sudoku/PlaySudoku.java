package sudoku;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PlaySudoku {

	private static Cell[][] gridUI; 

	private static JFrame frame;
	private static JPanel mainPanel,
	gridPanel,
	buttonPanel;

	private static JButton newGame,
	checkGame;

	private static PlaySudoku gamePlay;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		gamePlay = new PlaySudoku();
		gamePlay.start();

	
	}

private void start(){
	
	Grid griddata = new Grid();
	griddata.printGrid();
	gridUI = new Cell[9][9];


	frame = new JFrame("Play Suodku");
	frame.setSize(600, 500);
	frame.setMinimumSize(new Dimension(600,400));
	mainPanel = new JPanel();
	frame.add(mainPanel);		


	gridPanel = new JPanel();
	gridPanel.setLayout(new GridLayout(9, 9));
	mainPanel.setLayout(new FlowLayout());
	mainPanel.add(gridPanel);


	buttonPanel = new JPanel();
	buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS ));
	newGame = new JButton("new Game");
	buttonPanel.add(newGame);
	NewGameAction newGameButton= new NewGameAction();
	
	checkGame = new JButton("Check Game");
	buttonPanel.add(checkGame);
	
	mainPanel.add(buttonPanel);
	Cell tempCell;
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {

			tempCell = new Cell(i,j,griddata.getValue(i, j));
			gridUI[i][j] = tempCell;
			gridPanel.add(tempCell);
		}
	}

	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
}
	public class NewGameAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
