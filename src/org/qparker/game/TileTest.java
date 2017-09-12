package org.qparker.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class TileTest {

	@Test
	public void testGetValue() {
		Tile tile_val2 = new Tile(2);
		Tile tile_val4 = new Tile(4);
		assertEquals(tile_val2.getValue(), 2);
		assertEquals(tile_val4.getValue(), 4);
	}

	@Test
	public void testSetValue() {
		Tile tile = new Tile(2);
		tile.setValue(8);
		assertEquals(tile.getValue(), 8);
	}
	
	@Test
	public void testCanCombineWith() {
		Tile tile = new Tile(2);
		assertTrue(tile.canCombineWith(new Tile(2)));
		assertFalse(tile.canCombineWith(new Tile(8)));
	}

	@Test
	public void testCombineWith() {
		Tile tile0 = new Tile(2);
		Tile tile1 = new Tile(2);
		tile0.combineWith(tile1);
		assertEquals(tile0.getValue(), 4);
	}

}
