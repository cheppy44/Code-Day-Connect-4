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
		gameGrid = new Grid(7, 6);
		gui = new GUI(gameGrid);

		handler = new NetworkHandler(gameGrid);
		handler.start(gui);
		// new Thread(visualizer = new NetworkVisualizer(network.getNodes()));
		// //Visualization lives here when we want to enable that again
		// visualizer.start();

	}

	public static void main(String[] args) {
		new Connect4();
	}

}
