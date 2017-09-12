package org.qparker.game;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;
import org.qparker.game.GameRunner.Moves;

public class GameRunnerTest {

	@Test
	public void test() {
		GameRunner gameRunner = new GameRunner();
		gameRunner.startGame();
		gameRunner.printBoard();
		
		//left
		System.out.println("Left");
		gameRunner.makeMove(Moves.left);
		gameRunner.printBoard();
		
		//right
		System.out.println("Right");
		gameRunner.makeMove(Moves.right);
		gameRunner.printBoard();
		
		//up
		System.out.println("Up");
		gameRunner.makeMove(Moves.up);
		gameRunner.printBoard();
		
		//down
		System.out.println("Down");
		gameRunner.makeMove(Moves.down);
		gameRunner.printBoard();
	}

	@Test
	public void userTest() {
		Scanner scan = new Scanner(System.in);
		GameRunner gameRunner = new GameRunner();
		gameRunner.startGame();
		gameRunner.printBoard();
		
		for(int i = 0; i < 10 ; i++) {
			System.out.print("Left(0), Right(1), Up(2), Down(3): ");
			int input = scan.nextInt();
			scan.nextLine();
			
			Moves move = Moves.values()[input];
			gameRunner.makeMove(move);
			gameRunner.printBoard();
		}
		
		scan.close();
	}
}
