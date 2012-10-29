package com.paragp.games.gamefish;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

class Sounds {
	private static Clip clipEat;
	private static Clip clipAww;
	private static Clip clipWin;
	private static Clip clipBackGround;
	private static Thread bkGroundMusicThread;
	private static final String path = "sounds\\";
	
	public static void load() {
		try {
			File audioFile = new File(path + "crunch.wav");
			AudioInputStream stream = AudioSystem.getAudioInputStream(audioFile);	
			AudioFormat audioFormat = stream.getFormat();
			byte[] sound = new byte[20000];
			stream.read(sound);			
			DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);
			clipEat = (Clip) AudioSystem.getLine(info);
			clipEat.open(audioFormat, sound, 0, sound.length);
			
			audioFile = new File(path + "loose.wav");
			stream = AudioSystem.getAudioInputStream(audioFile);	
			audioFormat = stream.getFormat();
			sound = new byte[50000];
			stream.read(sound);			
			info = new DataLine.Info(Clip.class, audioFormat);
			clipAww = (Clip) AudioSystem.getLine(info);
			clipAww.open(audioFormat, sound, 0, sound.length);

			audioFile = new File(path + "underwater.wav");
			stream = AudioSystem.getAudioInputStream(audioFile);	
			audioFormat = stream.getFormat();
			sound = new byte[2000000];
			stream.read(sound);			
			info = new DataLine.Info(Clip.class, audioFormat);
			clipBackGround = (Clip) AudioSystem.getLine(info);
			clipBackGround.open(audioFormat, sound, 0, sound.length);

			audioFile = new File(path + "win.wav");
			stream = AudioSystem.getAudioInputStream(audioFile);	
			audioFormat = stream.getFormat();
			sound = new byte[80000];
			stream.read(sound);			
			info = new DataLine.Info(Clip.class, audioFormat);
			clipWin = (Clip) AudioSystem.getLine(info);
			clipWin.open(audioFormat, sound, 0, sound.length);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void playEat() {
		try
		{			
			new Thread(new Runnable(){
				public void run() {
					try {
					clipEat.start();
					Thread.sleep(250);
					clipEat.stop();
					clipEat.setFramePosition(0);
					}
					catch(Exception e){}
					
				}
			
			}).start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void playLoose() {
		try
		{			
			new Thread(new Runnable(){
				public void run() {
					try {
					clipAww.start();
					Thread.sleep(3000);
					clipAww.stop();
					clipAww.setFramePosition(0);
					}
					catch(Exception e){}
					
				}
			
			}).start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void playBackGround() {
		try
		{			
			bkGroundMusicThread = new Thread(new Runnable(){
				public void run() {
					while (!Thread.interrupted()) {
						try {						
							clipBackGround.start();
							
							Thread.sleep(10000);
							clipBackGround.stop();
							clipBackGround.setFramePosition(0);
							}
							catch(Exception e){
								break;
							}						
					}					
				}
			
			});
			bkGroundMusicThread.start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void stopBackGround() {
		try
		{			
			bkGroundMusicThread.interrupt();
		}
		catch (Exception e){}
	}

	public static Thread getBkGroundMusicThread() {
		return bkGroundMusicThread;
	}
	public static void playWin() {
		try
		{			
			new Thread(new Runnable(){
				public void run() {
					try {
					clipWin.start();
					Thread.sleep(1000);
					clipWin.stop();
					clipWin.setFramePosition(0);
					}
					catch(Exception e){}
					
				}
			
			}).start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}