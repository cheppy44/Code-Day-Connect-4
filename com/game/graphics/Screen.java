package com.game.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.game.connect4.Grid;
import com.game.connect4.State;

public class Screen {
	private BufferedImage image;
	private Grid grid;
	private Graphics g;
	private int widthRect = 50;
	private int heightRect = 50;
	private int xRect = widthRect;
	private int yRect = heightRect;
	private int yHeight = 1;
	private int xWidth = 1;
	private int CirW = 5;
	private int CirH = 5;

	public Screen(int width, int height, Grid grid) {
		image = new BufferedImage(GUI.GUI_WIDTH, GUI.GUI_HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();
		this.grid = grid;

		while (yHeight != 7) {
			while (xWidth != 8) {
				g.drawRect(xWidth * xRect, yHeight * yRect, widthRect, heightRect);
				g.setColor(Color.BLUE);
				g.fillRect(xWidth * xRect, yHeight * yRect, widthRect, heightRect);
				g.drawRoundRect(xWidth * xRect, yHeight * yRect, widthRect - CirW, heightRect - CirH, widthRect, heightRect);
				g.setColor(Color.black);
				g.fillOval(xWidth * xRect, yHeight * yRect, widthRect - CirW, heightRect - CirH);
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
				g.fillOval(x * xRect + 50, (6 - y) * yRect, widthRect - CirW, heightRect - CirH);
			}
		}

	}

	public BufferedImage getImage() {
		return image;
	}

	private Object setxWidth(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
