package com.paragp.games.gamefish;

import java.awt.*;

class Constants {
	public static final int NUM_FISHES = 5;
	public static final int FISH_ADDER_SLEEP = 1000;
	public static final int ANIMATOR_SLEEP = 5;
	public static final int FISH_X_VEL = 5;
	public static final int FISH_Y_VEL = 3;	
	public static final int WIN_SCORE = 1000;
	
	public static int SIZE_X;
	public static int SIZE_Y;
	
	static {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		SIZE_X = screenSize.width;
		SIZE_Y = screenSize.height;

	}
	
}