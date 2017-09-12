package org.qparker.game;

import java.util.Scanner;

public class GameRunner {
	private boolean over;
	public Board board;
	
	enum Moves{
		left,
		right,
		up,
		down
	}
	
	public GameRunner() {
		this.over = false;
		this.board = new Board();
	}
	
	public boolean isOver() {
		return this.over;
	}
	
	public void endGame() {
		this.over = true;
	}
	
	public void startGame() {
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
			System.out.println("Move not valid");
		} else {
			boolean spawned = board.spawnTile();
			if (spawned)
				System.out.println(board);
			else
				this.over = true;
		}
	}
	
	public void printBoard() {
		System.out.println(board);
	}

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		GameRunner gameRunner = new GameRunner();
		gameRunner.startGame();
		
		while(!gameRunner.isOver()) {
			System.out.print("Left(0), Right(1), Up(2), Down(3): ");
			int input = scan.nextInt();
			scan.nextLine();
			if (input < Moves.values().length && input >= 0) {
				Moves move = Moves.values()[input];
				gameRunner.makeMove(move);
			} else {
				System.out.println("Invalid input");
			}
		}
		System.out.println("Game Over");
		scan.close();
	}
}
