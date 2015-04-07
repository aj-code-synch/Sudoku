package sudoku;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
						   checkGame,
						   giveHint;

	private static PlaySudoku gamePlay;

	private Grid griddata;


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		gamePlay = new PlaySudoku();
		gamePlay.start();


	}

	private void start(){

		if(griddata==null){
			griddata = new Grid();	
		}

		griddata.printGrid();



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
		NewGameAction newGameAction= new NewGameAction();
		newGame.addActionListener(newGameAction);
		buttonPanel.add(newGame);

		checkGame = new JButton("Check Game");
		CheckGame checkGameAction = new CheckGame();
		checkGame.addActionListener(checkGameAction);
		buttonPanel.add(checkGame);
		
		giveHint = new JButton("Help me out !");
		GiveHint giveHintAction = new GiveHint();
		giveHint.addActionListener(giveHintAction);
		buttonPanel.add(giveHint);
		
		



		mainPanel.add(buttonPanel);

		prepUI();



		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}

	private void prepUI(){
		gridUI = null;
		gridUI = new Cell[9][9];

		Cell tempCell;
		gridPanel.removeAll();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				tempCell = new Cell(i,j,griddata.getValue(i, j));
				gridUI[i][j] = tempCell;
				gridPanel.add(tempCell);
			}
		}

		int randIndex;
		Random rand = new Random();
		int x,y;
		for (int i = 0; i < 10; i++) {
			randIndex = rand.nextInt(81);
			x = randIndex / 9;
			y = randIndex % 9;
			gridUI[x][y].readOnly();

		}


	}
	public class NewGameAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gamePlay.griddata = null;
			gamePlay.griddata = new Grid();
			gamePlay.griddata.printGrid();
			prepUI();
            gridPanel.revalidate();
		}



	}
	public class CheckGame implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					String temp = gridUI[i][j].getText();
					if(!temp.equals("")){
						gridUI[i][j].checkValue();
					}
				}
			}
		}
	}
	
	public class GiveHint implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	

}

