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

	protected boolean checkGrid(int x, int y, int value){

		boolean numberOK = true;



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

			}
		}



		return numberOK;

	}


}
