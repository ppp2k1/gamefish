package com.paragp.games.gamefish;

import java.awt.Graphics;
import java.util.Random;

import javax.naming.directory.InvalidAttributesException;

class Fish{
	int x;
	int y;
	int xvel;
	int yvel;
	int id;
	String imageName;
	Random rnd = new Random();
	int w;
	int h;
	public void updatePoistion(Graphics g) {

		if (rnd.nextInt(100) == 7) {
			xflip();
		}		
				
		if ((yvel == 0) && (rnd.nextInt(10) > 7)) {
			if (rnd.nextInt(100) > 49) {
				y += Constants.FISH_Y_VEL;
			}
			else {
				y -= Constants.FISH_Y_VEL;
			}			
		}
		
		x+=xvel;
		y+=yvel;
		
		g.drawImage(Images.get(imageName), x, y, null);		
		checkBounds();
		
	}
	Fish(int id) throws InvalidAttributesException {
		
		if (id > 8) {
			throw new InvalidAttributesException("Id should not be greater than 8");
		}
		x = rnd.nextInt(Constants.SIZE_X);
		y = rnd.nextInt(Constants.SIZE_Y);
		xvel = rnd.nextInt(Constants.FISH_X_VEL)- 2 * (Constants.FISH_X_VEL - 1);
		
		if (rnd.nextInt(10) > 8) {
			yvel = rnd.nextInt(Constants.FISH_Y_VEL)- 2 * (Constants.FISH_Y_VEL - 1);
		}
		else {
			yvel = 0;
		}
		
		if (xvel == 0) {
			xvel = 3; 
		}
		
		if (xvel >  0 ) {
			imageName = "fish" + id;
		}
		else {
			imageName = "fish" + id + "_flip";
		}
		
		w = Images.get(imageName).getWidth();
		h = Images.get(imageName).getHeight();		
	}
	Fish() {
		x = rnd.nextInt(Constants.SIZE_X);
		y = rnd.nextInt(Constants.SIZE_Y);
		xvel = rnd.nextInt(Constants.FISH_X_VEL)- 2 * (Constants.FISH_X_VEL - 1);
		
		if (rnd.nextInt(10) > 8) {
			yvel = rnd.nextInt(Constants.FISH_Y_VEL)- 2 * (Constants.FISH_Y_VEL - 1);
		}
		else {
			yvel = 0;
		}
		
		if (xvel == 0) {
			xvel = 3; 
		}		
		
		id = rnd.nextInt(9);
		
		if (xvel >  0 ) {
			imageName = "fish" + id;
		}
		else {
			imageName = "fish" + id + "_flip";
		}
		
		w = Images.get(imageName).getWidth();
		h = Images.get(imageName).getHeight();
	}
	protected void xflip () {
		xvel *= -1;
		if (xvel > 0) {			
			imageName = "fish" + id;
		}
		else {
			imageName = "fish" + id + "_flip";
		}
	}
	protected void yflip () {
		yvel *= -1;
	}

	protected void checkBounds() {

		if (x > (Constants.SIZE_X - w)) {
			xflip();
			x = Constants.SIZE_X - w;
		}
		if (x < 0 ) {
			xflip();
			x = 0;
		}
		if (y > (Constants.SIZE_Y - h)) {
			yflip();
			y = Constants.SIZE_Y - h;
			
		}
		if (y < 0) {
			yflip();
			y = 0;			
		}

	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getId() {
		return id;
	}
	public String getImage() {
		return imageName;
	}
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getWidth() {
		return w;
	}
	public int getHieght() {
		return h;
	}
	public int getXvel() {
		return xvel;
	}
	public int getYvel() {
		return yvel;
	}
	protected void setXvel(int xvel) {
		this.xvel = xvel;
		if (xvel > 0) {			
			imageName = "fish" + id;
		}
		else {
			imageName = "fish" + id + "_flip";
		}		
	}
	protected void setYvel(int yvel) {
		this.yvel = yvel;
	}

}