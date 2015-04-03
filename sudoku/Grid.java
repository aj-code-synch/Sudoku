package sudoku;

import java.util.ArrayList;
import java.util.Random;

public class Grid {

	private Integer[][] grid = new Integer[9][9];

	public Grid(){
		Random rand = new Random();
		int next = 0;
		ArrayList<Integer> checked = new ArrayList<Integer>();
		Boolean newNum = false;
		Boolean numOK = false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				numOK = false;
				newNum = false;
				checked = null;
				checked = new ArrayList<Integer>();


				do {

					do {
						next = rand.nextInt(10);
						if(next==0){next = 1;}

						if (checked.contains(next)==false) {
							newNum = true;
						}else {
							System.out.println(checked);
							System.out.println(next);
						}
						
					} while (newNum == false);


					numOK = checkGrid(i, j, next);

					if(numOK == false){
						checked.add(next);
						newNum = false;
					}

					if(checked.size() == 9){
						//All have been checked. Restart everything :(
						System.out.println("All have been checked");
						
						printGrid();
						System.out.println(checked);
						System.out.println(next);
						i = 0;
						j = 0;
						grid = null;
						grid = new Integer[9][9];
						checked = null;
						checked = new ArrayList<Integer>();

					}

				} while (numOK == false);

				grid[i][j] = next;

			}

		}
	}


	protected boolean checkGrid(int x, int y, int value){

		boolean numberOK = true;

		System.out.println("Check " + x +"  " +y + "  " + value);


		//X GOES VERTICAL
		//Y GOES HORIZONTAL

		// Check Current Row
		for (int i = 0; i < y; i++) {
			//			System.out.println("Checking Row" + x + "  " + i);
			if (grid[x][i]==value) {
				numberOK = false;
				return numberOK;
			}
		}


		// Check Current Column
		for (int i = 0; i < x; i++) {
			if (grid[i][y]==value) {
				numberOK = false;
				return numberOK;
			}
		}	


		//		Check Small Grid

		if((x+1)%3 == 1){ 
			//			No Need. Same Row. 
		} //(x+1)%3 == 1


		if((x+1)%3 == 2){


			if((y+1)%3 == 1){
				//				-------------
				//				|   | A | B |
				//				-------------
				//				| X |   |   |
				//				-------------
				//				|   |   |   |
				//				-------------

				if(grid[x-1][y+1]==value){
					numberOK = false;
					return numberOK;
				}

				if(grid[x-1][y+2]==value){
					numberOK = false;
					return numberOK;
				}



			}



			if((y+1)%3 == 2){

				//				-------------
				//				| A |   | B |
				//				-------------
				//				|   | X |   |
				//				-------------
				//				|   |   |   |
				//				-------------

				if(grid[x-1][y-1]==value){
					numberOK = false;
					return numberOK;	
				}

				if(grid[x-1][y+1]==value){
					numberOK = false;
					return numberOK;	
				}

			}

			if((y+1)%3 == 0){

				//				-------------
				//				| A | B |   |
				//				-------------
				//				|   |   | X |
				//				-------------
				//				|   |   |   |
				//				-------------

				// A					
				if(grid[x-1][y-2]==value){
					numberOK = false;
					return numberOK;	
				}

				// B
				if(grid[x-1][y-1]==value){
					numberOK = false;
					return numberOK;	
				}	


			}			



		} //(x+1)%3 == 2

		if((x+1)%3 == 0){

			if((y+1)%3 == 1){			
				//				-------------
				//				|   | A | B |
				//				-------------
				//				|   | C | D |
				//				-------------
				//				| X |   |   |
				//				-------------


				// A					
				if(grid[x-2][y+1]==value){
					numberOK = false;
					return numberOK;	
				}

				// B
				if(grid[x-2][y+2]==value){
					numberOK = false;
					return numberOK;	
				}

				// C					
				if(grid[x-1][y+1]==value){
					numberOK = false;
					return numberOK;	
				}

				// D
				if(grid[x-1][y+2]==value){
					numberOK = false;
					return numberOK;	
				}				
			}

			if((y+1)%3 == 2){

				//				-------------
				//				| A |   | B |
				//				-------------
				//				| C |   | D |
				//				-------------
				//				|   | X |   |
				//				-------------

				// A					
				if(grid[x-2][y-1]==value){
					numberOK = false;
					return numberOK;	
				}

				// B					
				if(grid[x-2][y+1]==value){
					numberOK = false;
					return numberOK;	
				}		

				// C					
				if(grid[x-1][y-1]==value){
					numberOK = false;
					return numberOK;	
				}

				// D					
				if(grid[x-1][y+1]==value){
					numberOK = false;
					return numberOK;	
				}					

			}

			if((y+1)%3 == 0){

				//				-------------
				//				| A | B |   |
				//				-------------
				//				| C | D |   |
				//				-------------
				//				|   |   | X |
				//				-------------

				// A					
				if(grid[x-2][y-2]==value){
					numberOK = false;
					return numberOK;	
				}

				// B
				if(grid[x-2][y-1]==value){
					numberOK = false;
					return numberOK;	
				}

				// C					
				if(grid[x-1][y-2]==value){
					numberOK = false;
					return numberOK;	
				}

				// D
				if(grid[x-1][y-1]==value){
					numberOK = false;
					return numberOK;	
				}	

			}

		} //(x+1)%3 == 0


		return numberOK;
	}

	public int getValue(int x, int y){

		return grid[x][y];

	}

	public void printGrid(){
		
		int i = 0;
		int j = 0;
		boolean exit = false;
		try {
			for (i = 0; i < 9; i++) {
				for (j = 0; j < 9; j++) {
					if(grid[i][j]==null){
						exit = true;
						break;
						}
					
					System.out.print(grid[i][j] + "\t");

				}
				System.out.println("");
				if(exit == true){break;}
				
			}

		} catch (NullPointerException e) {
			// TODO: handle exception
		}

	}

}
