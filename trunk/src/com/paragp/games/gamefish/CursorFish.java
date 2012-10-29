package com.paragp.games.gamefish;

import java.awt.Graphics;

class CursorFish extends Fish {
	int previousX;
	int previousY;	
	
	CursorFish(int x, int y) {
		this.x = x;
		this.y = y;
		this.previousX = x;
		this.previousX = y;
		
		this.id = 10;
		this.xvel = 0;
		this.yvel = 0;
		
		imageName = "fish" + id;		
	}
	public void updatePoistion(Graphics g) {		
		
		g.drawImage(Images.get(imageName), x, y, null);		
		
		checkBounds();
		
		
	}
	public void setXY(int x, int y) {

		this.previousX = this.x;
		this.previousY = this.y;
		
		this.x = x;
		this.y = y;
		
		flip(this.x - previousX);
	}
	private void flip (int orientation) {
		
		if (orientation > 0) {			
			imageName = "fish" + id;		
		}
		else {
			imageName = "fish" + id + "_flip";		
		}
	}
	
}