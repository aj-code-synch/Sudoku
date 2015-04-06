package sudoku;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;


public class Cell extends JFormattedTextField{

	private int cellValue, x ,y ;
	private static CompoundBorder x3 = new CompoundBorder(
			BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK), 
			BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLUE));


	private static CompoundBorder y3 = new CompoundBorder(
			BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK), 
			BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLUE));

	private static CompoundBorder xy3 = new CompoundBorder(
			BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK), 
			BorderFactory.createMatteBorder(0, 0, 2, 2, Color.BLUE));

	private static Border allBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK); 

	//		BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLUE);
	//		
	//			}
	public Cell(int xx, int yy, int value){
		x = xx;
		y = yy;
		cellValue = value;
		this.setPreferredSize(new Dimension(50,50));

		if((x+1)%3==0 && (y+1)%3 != 0){
			this.setBorder(x3);

		}
		if((x+1)%3!=0 && (y+1)%3 == 0){
			this.setBorder(y3);
		}

		if((x+1)%3==0 && (y+1)%3 == 0){
			this.setBorder(xy3);

		}
		if((x+1)%3!=0 && (y+1)%3 != 0){
			this.setBorder(allBorder);
		}

	}

}
