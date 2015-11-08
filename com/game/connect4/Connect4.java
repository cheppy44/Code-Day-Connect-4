package com.game.connect4;

import com.game.graphics.GUI;
import com.game.network.Network;

public class Connect4 implements Runnable {
	public Grid gameGrid;
	public Network network;
	private boolean running = false; 

	public Connect4() {
		gameGrid = new Grid(7, 6);
		network = new Network(gameGrid);
	}
	
	public synchronized void start(){
		running = true;
		new Thread(this).start();
	}
	
	public synchronized void stop(){
		running = false; 
	}

	@Override
	public void run() {
		while(running){
			GUI gui = new GUI();
			gui.renderScreen();
		}
	}

//	public static void main(String[] args){
//		System.out.println("Hi");
//		new Connect4().start();
//	}
	
}
