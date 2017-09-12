package org.qparker.game;

public class Tile {
	
	private int value;
	private boolean combined;
	
	public Tile(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public boolean getCombined() {
		return this.combined;
	}
	
	public void setCombined(boolean combined) {
		this.combined = combined;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public boolean canCombineWith(Tile tile) {
		return !combined && tile != null && !tile.getCombined() && this.value == tile.getValue();
	}
	
	public void combineWith (Tile tile) {
		if (canCombineWith(tile)) {
			this.value *= 2;
			this.combined = true;
		}
		
	}
}
