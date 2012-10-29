package com.paragp.games.gamefish;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

class Images {
	private static final HashMap<String,BufferedImage> images = new HashMap<String, BufferedImage>();
	private static final String path = "images\\";
	// map to load the image and image name
	public static void load() {
		try {
			images.put("aquarium", ImageIO.read(new File(path  + "aquarium1.JPG")));
			
			
			images.put("fish0", ImageIO.read(new File(path  + "fish0.JPG")));
			images.put("fish1", ImageIO.read(new File(path  + "fish1.JPG")));
			images.put("fish2", ImageIO.read(new File(path  + "fish2.JPG")));
			images.put("fish3", ImageIO.read(new File(path  + "fish3.JPG")));
			images.put("fish4", ImageIO.read(new File(path  + "fish4.JPG")));
			images.put("fish5", ImageIO.read(new File(path  + "fish5.JPG")));
			images.put("fish6", ImageIO.read(new File(path  + "fish6.JPG")));
			images.put("fish7", ImageIO.read(new File(path  + "fish7.JPG")));
			images.put("fish8", ImageIO.read(new File(path  + "fish8.JPG")));
			images.put("fish9", ImageIO.read(new File(path  + "fish9.JPG")));
			images.put("fish10", ImageIO.read(new File(path  + "fish10.JPG")));
			
			images.put("fish0_flip", ImageIO.read(new File(path  + "fish0_flip.JPG")));
			images.put("fish1_flip", ImageIO.read(new File(path  + "fish1_flip.JPG")));
			images.put("fish2_flip", ImageIO.read(new File(path  + "fish2_flip.JPG")));
			images.put("fish3_flip", ImageIO.read(new File(path  + "fish3_flip.JPG")));
			images.put("fish4_flip", ImageIO.read(new File(path  + "fish4_flip.JPG")));
			images.put("fish5_flip", ImageIO.read(new File(path  + "fish5_flip.JPG")));
			images.put("fish6_flip", ImageIO.read(new File(path  + "fish6_flip.JPG")));
			images.put("fish7_flip", ImageIO.read(new File(path  + "fish7_flip.JPG")));
			images.put("fish8_flip", ImageIO.read(new File(path  + "fish8_flip.JPG")));
			images.put("fish9_flip", ImageIO.read(new File(path  + "fish9_flip.JPG")));
			images.put("fish10_flip", ImageIO.read(new File(path  + "fish10_flip.JPG")));
			
			images.put("gameover", ImageIO.read(new File(path  + "gameover.JPG")));
			images.put("youwin", ImageIO.read(new File(path  + "youwin.JPG")));
			images.put("2lives", ImageIO.read(new File(path  + "2lives.JPG")));
			images.put("1life", ImageIO.read(new File(path  + "1life.JPG")));
			
			images.put("splash", ImageIO.read(new File(path  + "splash.jpg")));
			images.put("splash_background", ImageIO.read(new File(path  + "splash_background.JPG")));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static BufferedImage get(String imageName) {
		return images.get(imageName);
	}
}