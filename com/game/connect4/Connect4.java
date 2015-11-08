package com.game.connect4;

import com.game.graphics.GUI;
import com.game.network.Network;
import com.game.network.NetworkVisualizer;

public class Connect4 {
	public Grid gameGrid;
	public Network network;
	private boolean running = false;
	GUI gui;

	NetworkVisualizer visualizer;

	public Connect4() {
		gameGrid = new Grid(7, 6);
		network = new Network(gameGrid);
		new Thread(gui = new GUI(gameGrid));
		new Thread(visualizer = new NetworkVisualizer(network.getNodes()));
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
