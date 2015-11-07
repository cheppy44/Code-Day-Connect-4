package com.game.unitTests;

import org.junit.Test;

import com.game.graphics.GUI;

public class GUITest {

	@Test
	public void test() {
		GUI gui = new GUI();
		gui.renderScreen();
	}

}
