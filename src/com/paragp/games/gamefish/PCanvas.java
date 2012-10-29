package com.paragp.games.gamefish;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

class PCanvas extends JPanel {
	
	private int sizex;
	private int sizey;	
	
	List<Fish> fishes;
	List<Fish> toBeRemoved;
	List<Fish> toBeAdded;
	CursorFish cursorFish;
	
	
	BufferedImage bufferImg;
	PCanvas(int sizex, int sizey) {
		this.sizex = sizex;
		this.sizey = sizey;		
		
		fishes = new ArrayList<Fish>();
		toBeRemoved = new ArrayList<Fish>();
		toBeAdded = new ArrayList<Fish>();
		
		for (int i = 0; i <= Constants.NUM_FISHES ; ++i) {
			fishes.add(new Fish());
		}
		cursorFish = new CursorFish(20, 30);
		fishes.add(cursorFish);
		
		

	}
	public void repaintChanges() {
		bufferImg = Utils.cloneBufferedImage(Images.get("aquarium"));
		
		Graphics g = bufferImg.createGraphics();
		((Graphics2D)g).setComposite(new ZComposite());		

		fishes.removeAll(toBeRemoved);
		toBeRemoved.clear();
		
		fishes.addAll(toBeAdded);
		toBeAdded.clear();

		for (Fish fish : fishes) {			
			fish.updatePoistion(g);
		}
		
		g.setFont(new Font("COMIC SANS MS", Font.TRUETYPE_FONT, 25));
		g.drawString(String.valueOf(Utils.getScore()), Constants.SIZE_X - 200, 30);
		
		repaint();
		
	}
	public void paintComponent(Graphics g) {
		g.drawImage(bufferImg, 0, 0, sizex, sizey, null);
	}
	public void updateCursor(int x, int y) {
		
		for (Fish fish : fishes) {
			if (fish instanceof CursorFish) {
				continue;
			}
			if ( (x > (fish.getX() - cursorFish.getWidth())) &&
				 (x < (fish.getX() + fish.getWidth()))	&&
				 (y > (fish.getY() - cursorFish.getHieght())) &&
				 (y < (fish.getY() + fish.getWidth())) ) {
				
				if (fish.getId() <= 5 ) {
					Utils.incrementScore(10);
					if (Utils.getScore() > Constants.WIN_SCORE) {
						Utils.getAnimator().stop();
						Utils.getAdder().stop();
					}
				}
				else {
					Utils.decrementScore(10);
				}
				if (fish instanceof KillerFish) {
					toBeRemoved.add(cursorFish);
					Utils.getAnimator().stop();	
					Utils.getAdder().stop();
				}
				else {
					toBeRemoved.add(fish);
					Sounds.playEat();
				}
			}
		}		
		cursorFish.setXY(x, y);
	}
	public void updateKillers(int x, int y) {
		for (Fish fish : fishes) {
			if (fish instanceof KillerFish) {				
				((KillerFish) fish).notifyCursorPosition(x, y);
			}
		}
	}
	public CursorFish getCursorFish() {
		return cursorFish;
	}
	public void addFishes(List<Fish> fishes) {
		this.toBeAdded.addAll(fishes);
	}
	public void removeFish(Fish fish) {
		this.toBeRemoved.add(fish);
	}
	public void displayGameOver() {
		bufferImg = Utils.cloneBufferedImage(Images.get("aquarium"));
		
		Graphics g = bufferImg.createGraphics();
		((Graphics2D)g).setComposite(new ZComposite());
		
		fishes.removeAll(toBeRemoved);
		
		for (Fish fish : fishes) {			
			fish.updatePoistion(g);
		}
		
		g.drawImage(Images.get("gameover"), Constants.SIZE_X / 2 - 180, Constants.SIZE_Y / 2 - 100, null); 
		g.setFont(new Font("COMIC SANS MS", Font.BOLD, 30));
		g.drawString("score : " + String.valueOf(Utils.getScore()), Constants.SIZE_X / 2 - 90, Constants.SIZE_Y / 2 - 10);
		Utils.getFrame().removeMouseMotionListener(Utils.getFrame().getMouseMotionListeners()[0]);
		repaint();
		Sounds.playLoose();
		Sounds.stopBackGround();
	}
	public void displayGameWon() {
		bufferImg = Utils.cloneBufferedImage(Images.get("aquarium"));
		
		Graphics g = bufferImg.createGraphics();
		((Graphics2D)g).setComposite(new ZComposite());
		
		fishes.removeAll(toBeRemoved);
		
		for (Fish fish : fishes) {			
			fish.updatePoistion(g);
		}
		
		g.drawImage(Images.get("youwin"), Constants.SIZE_X / 2 - 180, Constants.SIZE_Y / 2 - 100, null); 
		Utils.getFrame().removeMouseMotionListener(Utils.getFrame().getMouseMotionListeners()[0]);
		
		repaint();
		Sounds.playWin();
		Sounds.stopBackGround();
	}
	public void displayLivesRemaining(int lives) {
		bufferImg = Utils.cloneBufferedImage(Images.get("aquarium"));
		
		Graphics g = bufferImg.createGraphics();
		((Graphics2D)g).setComposite(new ZComposite());
		
		fishes.removeAll(toBeRemoved);
		
		for (Fish fish : fishes) {			
			fish.updatePoistion(g);
		}

		if (lives == 2) {
			g.drawImage(Images.get("2lives"), Constants.SIZE_X / 2 - 220, Constants.SIZE_Y / 2 - 100, null);
		}else if (lives == 1) {
			g.drawImage(Images.get("1life"), Constants.SIZE_X / 2 - 210, Constants.SIZE_Y / 2 - 100, null);
		}
		 

		repaint();
		Sounds.playLoose();

	}
	public void displaySplash() {
		bufferImg = Images.get("splash_background");
		
		Graphics g = bufferImg.createGraphics();
		((Graphics2D)g).setComposite(new ZComposite());
		
		g.drawImage(Images.get("splash"), 120, 150,  null);

		repaint();
	}

	public void reset() {

	}
	
}