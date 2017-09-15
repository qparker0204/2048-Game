package org.qparker.game;

import java.util.Random;

public class Board {
	
	private Tile[][] gameBoard;
	private Random rand;
	private int highestTile;
	private static final int BOARDSIZE = 4;
	
	public Board() {
		rand = new Random();
		gameBoard = new Tile[BOARDSIZE][BOARDSIZE];
	}
	
	public void setHighest(int highest) {
		this.highestTile = highest;
	}
	
	public int getHighest() {
		return highestTile;
	}
	
	public void spawnTile() {
		Tile tile;
		boolean spawned = false;
		if (rand.nextInt(10) == 1) 
			tile = new Tile(4);
		else
			tile = new Tile(2);
		
		int x = rand.nextInt(BOARDSIZE);
		int y = rand.nextInt(BOARDSIZE);
		
		while(!spawned) {
			if(emptySpot(x, y)) {
				gameBoard[x][y] = tile;
				spawned = true;
			}
			else {
				x = rand.nextInt(BOARDSIZE);
				y = rand.nextInt(BOARDSIZE);
			}	
		}
	}
	
	public boolean isFull() {
		for (int i = 0; i < BOARDSIZE; i++) {
			for (int j = 0; j < BOARDSIZE; j++) {
				if(emptySpot(i, j))
					return false;
			}
		}
		return true;
	}
	
	private boolean emptySpot(int x, int y) {
		if (gameBoard[x][y] == null)
			return true;
		return false;
	}
	
	public boolean shift(int start, int xIncr, int yIncr) {
		boolean moved = false;
		for (int i = 0; i < BOARDSIZE * BOARDSIZE; i++) {
			int j = Math.abs(start - i);
			int x = j / BOARDSIZE;
			int y = j % BOARDSIZE;
			
			if (gameBoard[x][y] == null)
				continue;
			
			int nextX = x + xIncr;
			int nextY = y + yIncr;
			
			while (nextX >= 0 && nextX < BOARDSIZE && nextY >= 0 && nextY < BOARDSIZE) {
				Tile cur = gameBoard[x][y];
				Tile next = gameBoard[nextX][nextY];

				if (next == null) {
					gameBoard[nextX][nextY] = cur;
					gameBoard[x][y] = null;
					x = nextX;
					y = nextY;
					nextX += xIncr;
					nextY += yIncr;
					moved = true;
					
				} else if (cur.canCombineWith(next)) {
					int value = next.combineWith(cur);
					if(value > getHighest()) {
						setHighest(value);
					}
					gameBoard[x][y] = null;
					moved = true;
					break;
				} else {
					break;
				}
			}
		}
		clearCombined();
		return moved;
	}
	
	public boolean shiftLeft() {
		return shift(0, 0, -1);
	}
	
	public boolean shiftRight() {
		return shift(BOARDSIZE * BOARDSIZE - 1, 0, 1);

	}
	
	public boolean shiftDown() {
		return shift(BOARDSIZE *BOARDSIZE - 1, 1, 0);
	}
	
	public boolean shiftUp() {
		return shift(0, -1, 0);
	}
	
	public void clearCombined() {
		for (int i = 0; i < BOARDSIZE; i++) {
			for (int j = 0; j < BOARDSIZE; j++) {
				if (gameBoard[i][j] != null)
					gameBoard[i][j].setCombined(false);
			}
		}
	}
	
	@Override
	public String toString() {
		String board = "";
		for (int i = 0; i < BOARDSIZE; i++) {
			for (int j = 0; j < BOARDSIZE; j++) {
				if (gameBoard[i][j] == null)
					board += "[-]";
				else
					board += "[" + gameBoard[i][j].getValue() + "]";
			}
			board += "\n";
		}
		
		return board;
	}
}
