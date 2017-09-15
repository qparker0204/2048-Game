package org.qparker.game;

import java.util.Scanner;

public class GameRunner {
	enum State{
		start,
		running,
		won,
		over
	}
	
	private State gameState = State.start;
	public Board board;
	private static final int WINSCORE = 2048;
	
	enum Moves{
		left,
		right,
		up,
		down
	}
	
	public GameRunner() {
		this.board = new Board();
	}
	
	public State getState() {
		return gameState;
	}
	
	public void setState(State state) {
		this.gameState = state;
	}
	
	public void startGame() {
		setState(State.running);
		board.spawnTile();
		board.spawnTile();
		System.out.println(board);
	}
	
	public void makeMove(Moves move) {
		boolean moved = false;
		switch (move) {
			case left:	moved = board.shiftLeft();
						break;
			case right:	moved = board.shiftRight();
						break;
			case up:		moved = board.shiftUp();
						break;
			case down:	moved = board.shiftDown();
						break;
		}
		if (!moved) {
			if (board.isFull()) {
				setState(State.over);
				System.out.println("Game Over");
			}
		} else {
			board.spawnTile();
		}
	}
	
	public void printBoard() {
		System.out.println(board);
	}

	public boolean isWon() {
		if (board.getHighest() == WINSCORE) {
			setState(State.won);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		GameRunner gameRunner = new GameRunner();
		gameRunner.startGame();
		
		while(gameRunner.getState() == State.running) {
			System.out.print("Left(0), Right(1), Up(2), Down(3): ");
			int input = scan.nextInt();
			scan.nextLine();
			if (input < Moves.values().length && input >= 0) {
				Moves move = Moves.values()[input];
				gameRunner.makeMove(move);
			} else {
				System.out.println("Invalid input");
			}
			gameRunner.printBoard();
			if(gameRunner.isWon())
				System.out.println("You Won");
		}
		scan.close();
	}
}
