package sudoku;

public class PlaySudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Grid griddata = new Grid();
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int value = griddata.getValue(i, j);
				System.out.print(griddata.getValue(i, j) + "/t");
				
			}
			System.out.println("");
			
		}

	}

}
