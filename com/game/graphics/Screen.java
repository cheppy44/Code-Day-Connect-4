package com.game.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Screen {
	private BufferedImage image;

	public Screen(int width, int height) {
		image = new BufferedImage(GUI.GUI_WIDTH, GUI.GUI_HEIGHT, BufferedImage.TYPE_INT_RGB);
	}

	public void update() { //Update screen. Drawing happens in this method.
		Graphics g = image.getGraphics();

		//Image drawing commands here. Use g to draw onto the image.
		g.drawRect(10, 10, 10, 10);
		g.drawImage(image, 0, 0, null);
	}

	public BufferedImage getImage() {
		return image;
	}
}
