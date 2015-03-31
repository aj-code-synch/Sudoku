package sudoku;

public class ArrayDirection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] testArray = new int[9][9];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
			testArray[i][j] = i*5 + j;	
			}
		}

		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
			System.out.print(testArray[i][j] + "\t");	
			}
			System.out.println("");
		}

	}

}
