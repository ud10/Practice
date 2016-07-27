package backtracking;
import java.util.*;
public class Sudoku {

	public static void main(String[] args) {
//      [53..7....], 
//		[6..195...],
//		[.98....6.], 
//		[8...6...3], 
//		[4..8.3..1], 
// 		[7...2...6], 
//		[.6....28.], 
//		[...419..5], 
//		[....8..79]	
		ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> t = new ArrayList<Character>();
		t.add('5');t.add('3');t.add('.');t.add('.');t.add('7');t.add('.');t.add('.');t.add('.');t.add('.');
			a.add(t);t.clear();
		t.add('6');t.add('.');t.add('.');t.add('1');t.add('9');t.add('5');t.add('.');t.add('.');t.add('.');
			a.add(t);t.clear();
		t.add('.');t.add('9');t.add('8');t.add('.');t.add('.');t.add('.');t.add('.');t.add('6');t.add('.');
			a.add(t);t.clear();
		t.add('8');t.add('.');t.add('.');t.add('.');t.add('6');t.add('.');t.add('.');t.add('.');t.add('3');
			a.add(t);t.clear();
		t.add('4');t.add('.');t.add('.');t.add('8');t.add('.');t.add('3');t.add('.');t.add('.');t.add('1');
			a.add(t);t.clear();
		t.add('7');t.add('.');t.add('.');t.add('.');t.add('2');t.add('.');t.add('.');t.add('.');t.add('6');
			a.add(t);t.clear();
		t.add('.');t.add('6');t.add('.');t.add('.');t.add('.');t.add('.');t.add('2');t.add('8');t.add('.');
			a.add(t);t.clear();
		t.add('.');t.add('.');t.add('.');t.add('4');t.add('1');t.add('9');t.add('.');t.add('.');t.add('5');
			a.add(t);t.clear();
		t.add('.');t.add('.');t.add('.');t.add('.');t.add('8');t.add('.');t.add('.');t.add('7');t.add('9');
			a.add(t);t.clear();
	
		solveSudoku(a);
		for(int i = 0;i<9;i++){
			for(int j = 0;j<9;j++){
				System.out.print(a.get(i).get(j));
			}
			System.out.println("");
		}
    }
	
	public static void solveSudoku(ArrayList<ArrayList<Character>> a) {
		solveHelper(a);
	}
	private static boolean solveHelper(ArrayList<ArrayList<Character>> board) {
       for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.get(i).get(j) == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(i, j, k, board)) {
                        	board.get(i).set(j, k);
                        	//board[i][j] = k;
                            if (solveHelper(board) == true) {
                                return true;
                            }
                            board.get(i).set(j, '.');
                            //board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
	 }
	private static boolean isValid(int row, int col, char target, ArrayList<ArrayList<Character>> board) {
        // check the row and column
        for (int i = 0; i < 9; i++) {
            if ((board.get(row).get(i) == target) || (board.get(i).get(col) == target)) {
                return false;
            }
        }
         
        // check the block
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = (row / 3) * 3 + i; // nth block * block_size  + offset
                int y = (col / 3) * 3 + j;
                if (board.get(x).get(y) == target) {
                    return false;
                }
            }
        }
        return true;
    }
}
