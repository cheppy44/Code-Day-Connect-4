package com.game.graphics;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	public static final int GUI_WIDTH = 500;
	public static final int GUI_HEIGHT = 500;

	private JFrame frame;
	private DrawPanel drawPanel;
	private Screen screen;

	public GUI() {
		screen = new Screen(GUI_WIDTH, GUI_HEIGHT);
		frame = new JFrame("Test");

		drawPanel = new DrawPanel();
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setResizable(false);
		frame.setSize(GUI_WIDTH, GUI_HEIGHT);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

	}

	public void renderScreen() {
		screen.update();
		frame.repaint();
	}

	class DrawPanel extends JPanel {

		@Override
		public void paintComponent(Graphics g) {
			g.drawImage(screen.getImage(), 0, 0, null);
		}
	}
}
