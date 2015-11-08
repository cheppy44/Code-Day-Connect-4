package com.game.connect4;

import com.game.evolution.NetworkHandler;
import com.game.graphics.GUI;
import com.game.network.NetworkVisualizer;

public class Connect4 {
	public Grid gameGrid;
	private boolean running = false;
	GUI gui;
	NetworkHandler handler;
	NetworkVisualizer visualizer;

	public Connect4() {
		handler = new NetworkHandler();
		gameGrid = new Grid(7, 6);
		new Thread(gui = new GUI(gameGrid));
		visualizer.start();
		gui.start();

	}

	public synchronized void start() {
		running = true;
	}

	public synchronized void stop() {
		running = false;
	}

	public static void main(String[] args) {
		new Connect4();
	}

}
