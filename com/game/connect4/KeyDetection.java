package com.game.connect4;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyDetection extends KeyAdapter {
	private void keyReleased() {
		int i = 1;
		while (i == 1) {
			int key1 = KeyEvent.KEY_RELEASED;
			System.out.println(key1);
		}
	}

	public void main(String[] args) {
		KeyDetection keyDetector = new KeyDetection();
	}
}
