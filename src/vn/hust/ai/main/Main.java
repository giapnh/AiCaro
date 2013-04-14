package vn.hust.ai.main;

import vn.hust.ai.board.BoardInfo;
import vn.hust.ai.board.BoardState;

public class Main {

	public Main() {
		BoardInfo boardInfo = new BoardInfo();
		boardInfo.test();
		System.out.println(boardInfo.checkWin((byte) 1, 7, 7));
	}

	private void miniMaxDecision(BoardState state) {

	}

	int min() {

		return 0;
	}

	int max() {
		return 0;
	}

	public static void main(String[] args) {
		Main main = new Main();
	}
}
