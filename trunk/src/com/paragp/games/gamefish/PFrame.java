package com.paragp.games.gamefish;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

class PFrame extends JFrame {
	private PCanvas canvas;
	
	PFrame() {
		setBounds(0,0,Constants.SIZE_X, Constants.SIZE_Y);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		setUndecorated(true);
		canvas = new PCanvas(Constants.SIZE_X, Constants.SIZE_Y);
		add(canvas);
		
		setVisible(true);	
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
					Game.exit();
				}
				if (ke.getKeyCode() == KeyEvent.VK_R) {					
					Game.restart();					
				}
				if (ke.getKeyCode() == KeyEvent.VK_P ||
						ke.getKeyCode() == KeyEvent.VK_ENTER) {					
					Game.pause();					
				}
				
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent me) {
				if (Game.isPaused()) {
					return;
				}
				canvas.updateCursor(me.getX(), me.getY());
				canvas.updateKillers(me.getX(), me.getY());
			}
		});
		Utils.setFrame(this);
		Sounds.playBackGround();
	}
	public void repaintChanges() {
		canvas.repaintChanges();
	}
	public PCanvas getCanvas() {
		return this.canvas;
	}
	public void reset() {
		canvas = new PCanvas(Constants.SIZE_X, Constants.SIZE_Y);
		add(canvas);
		setVisible(true);
	}
}