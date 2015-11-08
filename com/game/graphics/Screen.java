package com.game.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.game.connect4.Grid;
import com.game.connect4.State;

public class Screen {
	private BufferedImage image;
	Grid grid;
	Graphics g;
	int widthRect = 50;
	int heightRect = 50;
	int xRect = widthRect;
	int yRect = heightRect;
	int yHeight = 1;
	int xWidth = 1;

	public Screen(int width, int height, Grid grid) {
		image = new BufferedImage(GUI.GUI_WIDTH, GUI.GUI_HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
		this.grid = grid;

		while (yHeight != 7) {
			while (xWidth != 8) {
				g.drawRect(xWidth * xRect, yHeight * yRect, widthRect, heightRect);
				g.drawRoundRect(xWidth * xRect, yHeight * yRect, widthRect, heightRect, widthRect, heightRect);

				xWidth++;
			}
			xWidth = 1;
			yHeight++;

		}

		g.drawImage(image, 0, 0, null);
		int width1 = grid.getxWidth();
		int height1 = grid.getyHeight();
	}

	public void update() { // Update screen. Drawing happens in this method.

		// Image drawing commands here. Use g to draw onto the image.

		for (int y = 0; y < grid.getyHeight(); y++) {
			for (int x = 0; x < grid.getxWidth(); x++) {
				State state = grid.getSlot(x, y);
				if (state == State.red) {
					g.setColor(Color.red);
				} else if (state == State.yellow) {
					g.setColor(Color.yellow);
				} else {
					g.setColor(Color.black);
				}
				g.fillOval(x * xRect + 50, (6 - y) * yRect, widthRect, heightRect);
			}
		}

	}

	public BufferedImage getImage() {
		return image;
	}

	private Object setxWidth(int i) {
		System.out.println("hi");
		// TODO Auto-generated method stub
		return null;
	}
}
