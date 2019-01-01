package leetcode;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition. Each column must
 * contain the digits 1-9 without repetition. Each of the 9 3x3 sub-boxes of the
 * grid must contain the digits 1-9 without repetition.
 * 
 * A partially filled sudoku which is valid.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * Example 1:
 * 
 * Input: [ ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."], [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"], ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"], [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"], [".",".",".",".","8",".",".","7","9"]
 * ] Output: true Example 2:
 * 
 * Input: [ ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."], [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"], ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"], [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"], [".",".",".",".","8",".",".","7","9"]
 * ] Output: false Explanation: Same as Example 1, except with the 5 in the top
 * left corner being modified to 8. Since there are two 8's in the top left 3x3
 * sub-box, it is invalid. Note:
 * 
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable. Only the filled cells need to be validated according to the
 * mentioned rules. The given board contain only digits 1-9 and the character
 * '.'. The given board size is always 9x9.
 */
public class SolutionValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		int[] subBox = new int[9 + 9 + 9];

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				char numChar = board[row][col];

				if (numChar == '.') {
					continue;
				}

				int digit = 1 << (numChar - '0');

				if ((subBox[row] & digit) != 0) {
					return false;
				}
				subBox[row] = subBox[row] | digit;

				int colDigit = col + 9;
				if ((subBox[colDigit] & digit) != 0) {
					return false;
				}
				subBox[colDigit] = subBox[colDigit] | digit;

				int subDigit = (row / 3) * 3 + (col / 3) + 18;

				if ((subBox[subDigit] & digit) != 0) {
					return false;
				}
				subBox[subDigit] = subBox[subDigit] | digit;

			}
		}

		return true;
	}

}
