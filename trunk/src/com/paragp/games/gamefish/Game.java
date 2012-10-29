package com.paragp.games.gamefish;

public class Game {
	private int score;
	private int lives = 3;
	private PFrame frame;
	private static boolean pause;
	public Game() {
		Utils.setGame(this);
		Images.load();
		Sounds.load();		
		frame = new PFrame();
	}
	
	public void start() {
		frame.getCanvas().displaySplash();		
		while (lives > 0) {
			
			Animate animate = new Animate(frame);
			FishAdder fishAdder = new FishAdder(frame);		
		
			animate.start();
			fishAdder.start();
			
			if (lives == 3) {
				Game.pause();
			}
			
			try {
				animate.getRunner().join();
			} catch (InterruptedException e) {
			}
			
			if (score > Constants.WIN_SCORE) {
				frame.getCanvas().displayGameWon();
				break;
				
			} else {
				--lives;
				if (lives <= 0) {
					frame.getCanvas().displayGameOver();
					break;
				}
				frame.getCanvas().displayLivesRemaining(lives);				
			}
			try {					
				Thread.sleep(3000);
			} catch (InterruptedException e) {}
			frame.reset();
		}	
	}
	

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	public static void restart() {
		System.exit(255);
	}
	public static void pause() {
		pause = !pause;
		Utils.getAnimator().pause();
		Utils.getAdder().pause();
		
	}
	public static void exit() {
		System.exit(0);
	}
	public static boolean isPaused() {
		return pause;
	}
	
}
