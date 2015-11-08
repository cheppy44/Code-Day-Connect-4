package com.game.graphics;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.game.connect4.Grid;

public class GUI implements Runnable{
	public static final int GUI_WIDTH = 500;
	public static final int GUI_HEIGHT = 500;

	private JFrame frame;
	private DrawPanel drawPanel;
	private Screen screen;
	private Grid grid;
	private boolean running;

	public GUI(Grid gameGrid) {
		grid = gameGrid;
		screen = new Screen(GUI_WIDTH, GUI_HEIGHT, grid);
		frame = new JFrame("Test");

		drawPanel = new DrawPanel();
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setResizable(false);
		frame.setSize(GUI_WIDTH, GUI_HEIGHT);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

	}
	
	public void run() {
		screen.update();
		frame.repaint();
	}
	
	public synchronized void start() {
		running = true;
		while (running) {
			run();
		}
	}
	
	public synchronized void stop() {
		running = false;
	}

	class DrawPanel extends JPanel {

		@Override
		public void paintComponent(Graphics g) {
			g.drawImage(screen.getImage(), 0, 0, null);
		}
	}
}
