package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/3064
 * 
 * N x N 보드에 테러범들이 지뢰를 설치해 놓았다. 다행히도 가장자리 칸에는 지뢰가 없는 것으로 확인되어 지뢰 탐지기를 설치했다. 지뢰
 * 탐지기는 주변에 몇 개의 지뢰가 있는지를 보여준다. 즉, 가장자리 칸의 숫자는 인접한 칸에 있는 지뢰의 개수를 나타낸다.
 * 
 * 111000 
 * 2####0 
 * 3####1 
 * 3####1 
 * 2####1 
 * 112110 
 * 위 그림은 6 x 6 보드를 나타낸다. 이 보드에는 최대
 * 10개의 지뢰가 놓일 수 있다. 
 * 111000 
 * 2*###0 
 * 3***#1 
 * 3****1
 * 2*#*#1 
 * 112110 
 * 
 * 주어진 보드에 놓일 수 있는
 * 최대 지뢰 개수를 출력하는 프로그램을 작성하시오. 입력 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스의 첫 번째
 * 줄에는 보드의 크기 N(1 ≤ N ≤ 100)이 주어지고 두 번째 줄부터는 보드를 나타내는 N개의 문자열이 주어진다. 각 문자열의 길이는
 * N이다. 출력 각 테스트 케이스에 대해서 보드에 놓일 수 있는 최대 지뢰의 개수를 한 줄에 하나씩 출력한다.
 * 
 * @author hyeokcheol
 *
 */
public class Main3064 {

	/**
	 * test case 크기
	 */
	private int n = 1;

	/**
	 * 지뢰 데이터가 저장될 배열
	 */
	private char[][] board;

	public Main3064(int boardSize) {
		this.n = boardSize;
		board = new char[this.n + 2][this.n + 2];
	}

	public void setBoardMine(char mine, int x, int y) {
		board[x][y] = mine;
	}

	/**
	 * 가장 자리에 지뢰의 수는 인근한 지뢰의
	 * 
	 * 
	 * @return
	 */
	public int maxMines() {

		if (n < 3) {
			return 0;
		}

		if (n == 3) {
			if (board[1][1] == 1) {
				return 1;
			}
			return 0;
		}

		for (int x = 1; x <= n; x++) {
			if (x == 1 || x == n) {
				for (int y = 1; y <= n; y++) {
					defineMine(x, y);
				}

			} else {
				defineMine(x, 1);
				defineMine(x, n);
			}
		}

		return countMine();
	}

	private int countMine() {
		int mine = 0;

		for (int x = 2; x <= n - 1; x++) {
			if (x == 2 || x == n - 1) {
				for (int y = 2; y <= n - 1; y++) {
					if (board[x][y] == '*') {
						mine++;
					}
				}

			} else {
				if (board[x][2] == '*') {
					mine++;
				}

				if (board[x][n - 1] == '*') {
					mine++;
				}
			}
		}

		mine = mine + (this.n - 4) * (this.n - 4);
		return mine;
	}

	private void defineMine(int x, int y) {

		Stack<Point> boardStack = new Stack<Point>();

		char mine = board[x][y];
		int findMine = 0;
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (i != x || j != y) {
					char t = board[i][j];

					if (t == '#') {
						boardStack.push(new Point(i, j));
					} else if (t == '*') {
						findMine++;
					}
				}
			}
		}

		int additionMine = mine - findMine;

		if (additionMine == 0 || additionMine == boardStack.size()) {
			for (Point point : boardStack) {
				board[point.x][point.y] = (additionMine == 0) ? 0 : '*';
			}
		}
	}

	class Point {
		public int x = 0;
		public int y = 0;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {

		// 입력 부분
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testNumber = Integer.parseInt(br.readLine());

		int[] resultArray = new int[testNumber];

		for (int index = 0; index < testNumber; index++) {

			int boardSize = Integer.parseInt(br.readLine());

			Main3064 board = new Main3064(boardSize);

			for (int boardInputIndex = 0; boardInputIndex < boardSize; boardInputIndex++) {

				String boardContents = br.readLine();

				for (int col = 0; col < boardSize; col++) {

					char letter = boardContents.charAt(col);

					if (letter >= '0' && letter <= '9') {
						letter = (char) (letter - '0');
					}

					board.setBoardMine(letter, boardInputIndex + 1, col + 1);
				}
			}

			resultArray[index] = board.maxMines();
		}

		for (int result : resultArray) {
			System.out.println(result);
		}

	}

}
