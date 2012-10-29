package com.paragp.games.gamefish;

class Animate implements Runnable {
	Thread runner;
	PFrame frame;
	boolean pause;
	Animate(PFrame frame){
		this.frame = frame;
		runner = new Thread(this);
		Utils.setAnimator(this);
	}
	public void start() {
		runner.start();
	}
	public Thread getRunner() {
		return runner;
	}
	public void run() {
		while(!Thread.interrupted()) {

			while (pause) {
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) {break;}							
			}
			frame.repaintChanges();
			try {
				Thread.sleep(Constants.ANIMATOR_SLEEP);
			}
			catch(InterruptedException e) {							
				break;				
			}
		}
	}
	public void stop() {
		this.runner.interrupt();
	}
	public void pause() {
		pause = !pause;
	}
	
}