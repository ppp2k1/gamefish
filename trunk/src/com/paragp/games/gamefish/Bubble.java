package com.paragp.games.gamefish;

import java.awt.Graphics;

public class Bubble extends Fish {
	int size;
	Bubble(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.yvel = -1;
		this.imageName = "bubble";
		
	}
	public void updatePoistion(Graphics g) {

		xvel = 2-rnd.nextInt(2);
		x+=xvel;
		y+=yvel;
		
		g.drawImage(Images.get(imageName), x, y, null);		
		checkBounds();
		
	}

}
