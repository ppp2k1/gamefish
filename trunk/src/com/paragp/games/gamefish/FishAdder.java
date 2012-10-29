package com.paragp.games.gamefish;

import java.util.ArrayList;
import java.util.List;

class FishAdder implements Runnable {
	Thread runner;
	PFrame frame;
	long startTime;
	static long EPOCH1 = 4 * 1000;	
	boolean EPOCH1_ELAPSED;
	boolean pause;
	FishAdder(PFrame frame) {
		this.frame = frame;
		runner = new Thread(this);
		Utils.setAdder(this);
	}
	public void run() {
		while(!Thread.interrupted()) {
			
			while (pause) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {break;}					
			}
			
			List<Fish> fishes = new ArrayList<Fish>();			
			if (Utils.getRandom(10) > 8 )
			{				
				if (EPOCH1_ELAPSED || timeElapsed() > EPOCH1) {
					fishes.add(new KillerFish());
				}
			}
			else {
				fishes.add(new Fish());
			}
			frame.getCanvas().addFishes(fishes);
			try {
				Thread.sleep(Constants.FISH_ADDER_SLEEP);
			} catch (InterruptedException e) {
				break;
			}
		}		
	}
	public void start() {
		startTime = System.currentTimeMillis();
		runner.start();
	}
	public long timeElapsed(){
		return System.currentTimeMillis() - startTime;
	}
	public void stop(){
		runner.interrupt();
	}
	public Thread getRunner() {
		return runner;
	}
	public void pause() {
		pause = !pause;
	}
	
}