package vn.hust.ai.board;

import java.awt.Point;
import java.util.Stack;

public class BoardInfo {
	static final byte NULL_STATE = 0;
	static final byte MAX_STATE = 1;
	static final byte MIN_STATE = -1;

	static final int NUM_COL = 20;
	static final int NUM_ROW = 20;
	byte[][] board = new byte[NUM_COL][NUM_ROW];

	static final byte WIN_CONDITION = 5;

	public boolean isFinish = false;

	protected Stack<Node> nodeStack; // Chứa các ô đã đánh

	public void initBoard() {
		for (int i = 0; i < NUM_COL; i++) {
			for (int j = 0; j < NUM_ROW; j++) {
				board[i][j] = NULL_STATE;
			}
		}
	}

	public void test() {
		byte test[][] = {
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		board = test.clone();
	}

	/* Constructors */
	public BoardInfo() {
		initBoard();
		nodeStack = new Stack<Node>();
	}

	public void printBoardState() {
		for (int i = 0; i < NUM_COL; i++) {
			for (int j = 0; j < NUM_ROW; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public boolean checkWin(byte piece, int row, int col) {
		this.printBoardState();
		int i;
		int nodesInARow = 1;
		Point startP = new Point(row, col);
		Point endP = new Point(row, col);

		// Kiểm tra hàng dọc
		for (i = row - 1; i >= 0; i--)
			if (board[i][col] == piece) {
				nodesInARow++;
				// startP.set(i, col);
			} else
				break;

		for (i = row + 1; i < NUM_ROW; i++)
			if (board[i][col] == piece) {
				nodesInARow++;
				// endP.set(i, col);
			} else
				break;

		if (nodesInARow >= WIN_CONDITION) {
			// TODO
			return true;
		}

		// Kiểm tra hàng ngang

		nodesInARow = 1;
		// startP.set(row, col);
		// endP.set(row, col);

		for (i = col - 1; i >= 0; i--)
			if (board[row][i] == piece) {
				nodesInARow++;
				// startP.set(row, i);
			} else
				break;

		for (i = col + 1; i < NUM_COL; i++)
			if (board[row][i] == piece) {
				nodesInARow++;
				// endP.set(row, i);
			} else
				break;

		if (nodesInARow >= WIN_CONDITION) {
			// gameOver(piece, startP, endP);
			return true;
		}

		// Kiểm tra chéo trái trên

		nodesInARow = 1;
		// startP.set(row, col);
		// endP.set(row, col);

		for (i = 1; i <= Math.min(row, col); i++)
			if (board[row - i][col - i] == piece) {
				nodesInARow++;
				// startP.set(row - i, col - i);
			} else
				break;

		for (i = 1; i < Math.min(NUM_ROW - row, NUM_COL - col); i++)
			if (board[row + i][col + i] == piece) {
				nodesInARow++;
				// endP.set(row + i, col + i);
			} else
				break;

		if (nodesInARow >= WIN_CONDITION) {
			// gameOver(piece, startP, endP);
			return true;
		}

		// Kiểm tra chéo phải trên

		nodesInARow = 1;
		// startP.set(row, col);
		// endP.set(row, col);

		for (i = 1; i <= Math.min(NUM_ROW - row - 1, col); i++)
			if (board[row + i][col - i] == piece) {
				nodesInARow++;
				// startP.set(row + i, col - i);
			} else
				break;

		for (i = 1; i <= Math.min(row, NUM_COL - col - 1); i++)
			if (board[row - i][col + i] == piece) {
				nodesInARow++;
				// endP.set(row - i, col + i);
			} else
				break;

		if (nodesInARow >= WIN_CONDITION) {
			// gameOver(piece, startP, endP);
			return true;
		}

		for (i = 0; i < NUM_ROW; i++)
			for (int j = 0; j < NUM_COL; j++)
				if (board[i][j] < 0)
					return false;
		// gameOver((byte) -1, new Point(-1, -1), new Point(-1, -1));
		return false;
	}

}
