package com.paragp.games.gamefish;

import java.awt.Graphics;

class KillerFish extends Fish {
	private static int MIN_VEL = 5;	
	private static int MAX_VEL = 10;
	
	KillerFish() {
		int i = rnd.nextInt(20);
		this.x = i > 10 ? i : Constants.SIZE_X- i;
		this.y = i > 10 ? i : Constants.SIZE_Y- i;
		this.id = 9;
		this.xvel = 5;
		this.yvel = 5;
		imageName = "fish" + id;		
	}
	
	public void updatePoistion(Graphics g) {
		x+=xvel;
		y+=yvel;
		g.drawImage(Images.get(imageName), x, y, null);
		checkBounds();
		Fish cursorFish = Utils.getFrame().getCanvas().getCursorFish();
		if ( (x > (cursorFish.getX() - getWidth())) &&
				 (x < (cursorFish.getX() + cursorFish.getWidth()))	&&
				 (y > (cursorFish.getY() - getHieght())) &&
				 (y < (cursorFish.getY() + cursorFish.getWidth())) ) {
			Utils.getFrame().getCanvas().removeFish(cursorFish);
			Utils.getAnimator().stop();
		}
		
	}
	public void notifyCursorPosition(int xpos, int ypos) {		
		
		if ((xpos > x) && (xvel < 0)) {
			xvel = Utils.normalize(Math.abs((xpos - x) / 20), MIN_VEL, MAX_VEL);
			setXvel(xvel);
		}
		if ((xpos < x) && (xvel > 0)) {
			xvel = Utils.normalize(Math.abs((xpos - x) / 20), MIN_VEL, MAX_VEL) * -1;
			setXvel(xvel);
		}
		
		if ((ypos > y) && (yvel < 0) ) {
			yvel = Utils.normalize(Math.abs((ypos - y) / 20), MIN_VEL, MAX_VEL) ;			
		}
		if ((ypos < y) && (yvel > 0) ) {
			yvel = Utils.normalize(Math.abs((ypos - y) / 20), MIN_VEL, MAX_VEL) * -1;			
		}

	}
	
	
}