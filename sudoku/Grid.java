package sudoku;

import java.util.ArrayList;
import java.util.Random;

public class Grid {

	private Integer[][] grid;

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

						if (!checked.contains(next)) {
							newNum = true;
						}
					} while (newNum = false);


					numOK = checkGrid(i, j, next);

					if(numOK == false){
						checked.add(next);
					}

					if(checked.size() == 9){
						//						All have been checked. Restart everything :(
						i = 0;
						j = 0;
						grid = null;
						checked = null;

					}

				} while (numOK == false);

			}

		}
	}


	protected boolean checkGrid(int yy, int xx, int value){

		boolean numberOK = true;

		int y = xx;
		int x = yy;


		// Check Current Row
		for (int i = 0; i < x-1; i++) {
			if (grid[i][y]==value) {
				numberOK = false;
				return numberOK;
			}
		}


		// Check Current Column
		for (int i = 0; i < x-1; i++) {
			if (grid[x][i]==value) {
				numberOK = false;
				return numberOK;
			}
		}	


		//		Check Small Grid

		if((x+1)%3 == 1){

			if((y+1)%3 == 1){
				//              No Need				
				//				-------------
				//				| X |   |   |
				//				-------------
				//				|   |   |   |
				//				-------------
				//				|   |   |   |
				//				-------------

			}


			if((y+1)%3 == 2){			
				//				-------------
				//				|   | A | B |
				//				-------------
				//				| X |   |   |
				//				-------------
				//				|   |   |   |
				//				-------------

				// A				
				if(grid[x+1][y-1]==value){
					numberOK = false;
					return numberOK;					
				}
				// B
				if(grid[x+2][y-1]==value){
					numberOK = false;
					return numberOK;					
				}

			}
			if((y+1)%3 == 0){			
				//					-------------
				//					|   | A | B |
				//					-------------
				//					|   | C | D |
				//					-------------
				//					| X |   |   |
				//					-------------

				// A
				if(grid[x+1][y-2]==value){
					numberOK = false;
					return numberOK;					
				}
				// B
				if(grid[x+2][y-2]==value){
					numberOK = false;
					return numberOK;					
				}

				// C
				if(grid[x+1][y-1]==value){
					numberOK = false;
					return numberOK;					
				}
				// D
				if(grid[x+2][y-1]==value){
					numberOK = false;
					return numberOK;					
				}


			}


		} //(x+1)%3 == 1


		if((x+1)%3 == 2){

			if((y+1)%3 == 1){
				//              No Need				
				//				-------------
				//				|   | X |   |
				//				-------------
				//				|   |   |   |
				//				-------------
				//				|   |   |   |
				//				-------------

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

				if(grid[x+1][y-1]==value){
					numberOK = false;
					return numberOK;	
				}

			}

			if((y+1)%3 == 0){

				//				-------------
				//				| A |   | B |
				//				-------------
				//				| C |   | D |
				//				-------------
				//				|   | X |   |
				//				-------------

				// A					
				if(grid[x-1][y-2]==value){
					numberOK = false;
					return numberOK;	
				}

				// B
				if(grid[x+1][y-2]==value){
					numberOK = false;
					return numberOK;	
				}	

				// C
				if(grid[x-1][y-1]==value){
					numberOK = false;
					return numberOK;	
				}

				// D
				if(grid[x+1][y-1]==value){
					numberOK = false;
					return numberOK;	
				}		

			}			



		} //(x+1)%3 == 2

		if((x+1)%3 == 0){

			if((y+1)%3 == 1){
				//              No Need				
				//				-------------
				//				|   |   | X |
				//				-------------
				//				|   |   |   |
				//				-------------
				//				|   |   |   |
				//				-------------
			}

			if((y+1)%3 == 1){

				//				-------------
				//				| A | B |   |
				//				-------------
				//				|   |   | X |
				//				-------------
				//				|   |   |   |
				//				-------------

				// A					
				if(grid[x-2][y-1]==value){
					numberOK = false;
					return numberOK;	
				}

				// A					
				if(grid[x-1][y-1]==value){
					numberOK = false;
					return numberOK;	
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
					if(grid[x-1][y-2]==value){
						numberOK = false;
						return numberOK;	
					}	

					// C					
					if(grid[x-2][y-1]==value){
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




		} //(x+1)%3 == 0

		return numberOK;
	}

	public int getValue(int x, int y){
		
		return grid[x][y];
		
	}

}
