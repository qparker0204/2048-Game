package org.qparker.game;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.Scanner;

import org.junit.Test;
import org.qparker.game.GameRunner.Moves;
import org.qparker.game.GameRunner.State;

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
		Random rand = new Random();
		GameRunner gameRunner = new GameRunner();
		gameRunner.startGame();
		gameRunner.printBoard();
		
		while(gameRunner.getState() == State.running) {
			Moves move = Moves.values()[rand.nextInt(3)];
			gameRunner.makeMove(move);
			gameRunner.printBoard();
		}
	}
}
