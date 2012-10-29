package com.paragp.games.gamefish;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Hashtable;
import java.util.Random;

class Utils {
	private static PFrame frame;
	private static Animate animate;
	private static FishAdder adder;
	private static Game game;
	
	private static Random rnd = new Random();
	
	
	public static BufferedImage cloneBufferedImage(BufferedImage src) {
		String[] pnames = src.getPropertyNames();
		Hashtable<String, Object> cproperties = new Hashtable<String,
		Object>();
		if(pnames != null) {
		   for(int i = 0; i < pnames.length; i++) {
		       cproperties.put(pnames[i], src.getProperty(pnames[i]));
		   }
		}
		WritableRaster wr = src.getRaster();
		WritableRaster cwr = wr.createCompatibleWritableRaster();
		cwr.setRect(wr);
		BufferedImage dest = new BufferedImage(src.getColorModel(), cwr, src.isAlphaPremultiplied(), cproperties);
		return dest;
	}
	public static void setFrame (PFrame f) {
		frame = f;
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
		frame.setCursor(blankCursor);
	}
	public static int getRandom(int range) {
		return rnd.nextInt(range);
	}
	public static int normalize(int num, int min, int max) {
		if (num <= min) {
			return min;
		} else if (num >= max){
			return max;
		} else {
			return num;
		}
	}
	public static PFrame getFrame() {
		return Utils.frame;
	}
	public static void setAnimator(Animate a) {
		Utils.animate = a;
	}
	public static Animate getAnimator() {
		return Utils.animate;
	}
	public static void incrementScore(int by) {
		Utils.game.setScore(game.getScore() + by);
	}
	public static void decrementScore(int by) {
		Utils.game.setScore(game.getScore() - by);
	}
	public static int getScore() {
		return Utils.game.getScore();
	}
	public static void setGame(Game game) {
		Utils.game = game;
	}
	public static Game getGame() {
		return Utils.game;
	}
	public static FishAdder getAdder() {
		return Utils.adder;
	}
	public static void setAdder(FishAdder adder) {
		Utils.adder = adder;
	}
}