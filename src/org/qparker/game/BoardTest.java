package org.qparker.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {
	
	@Test
	public void testSpawnTile() {
		Board board = new Board();
		board.spawnTile();
	}

	@Test
	public void testShiftLeft() {
		Board board = new Board();
		board.spawnTile();
		board.spawnTile();
		System.out.println("Shift left");
		System.out.println(board);
		board.shiftLeft();
		System.out.println(board);
		board.spawnTile();
		System.out.println(board);
		board.shiftLeft();
		System.out.println(board);
	}

	@Test
	public void testShiftRight() {
		Board board = new Board();
		board.spawnTile();
		board.spawnTile();
		System.out.println("Shift right");
		System.out.println(board);
		board.shiftRight();
		System.out.println(board);	
	}

	@Test
	public void testShiftDown() {
		Board board = new Board();
		board.spawnTile();
		board.spawnTile();
		System.out.println("Shift down");
		System.out.println(board);
		board.shiftDown();
		System.out.println(board);	
	}

	@Test
	public void testShiftUp() {
		Board board = new Board();
		board.spawnTile();
		board.spawnTile();
		System.out.println("Shift up");
		System.out.println(board);
		board.shiftUp();
		System.out.println(board);
	}

}
