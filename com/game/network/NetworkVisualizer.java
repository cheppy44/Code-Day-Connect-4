package com.game.network;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NetworkVisualizer implements Runnable {
	public static final int GUI_WIDTH = 500;
	public static final int GUI_HEIGHT = 500;

	private JFrame frame;
	private DrawPanel drawPanel;
	private NetworkScreen screen;
	private boolean running;
	private List<Node> nodeData;

	public NetworkVisualizer(List<Node> nodeData) {
		this.nodeData = nodeData;
		screen = new NetworkScreen(GUI_WIDTH, GUI_HEIGHT);
		frame = new JFrame("NetworkVisualizer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		drawPanel = new DrawPanel();

		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

		frame.setResizable(false);
		frame.setSize(GUI_WIDTH, GUI_HEIGHT);
		frame.setLocationByPlatform(true);
		//frame.setFocusable(true);
		frame.setVisible(true);
		//renderScreen(); //Doesn't need to be called from here. Should it be?
	}

	class DrawPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g) {
			g.drawImage(screen.getImage(), 0, 0, null);
		}
	}

	public void renderScreen() {
		screen.update(nodeData);
		frame.repaint();
	}

	@Override
	public void run() {
		screen.update(nodeData);
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
}
