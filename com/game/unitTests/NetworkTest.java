package com.game.unitTests;

import org.junit.Test;

import com.game.connect4.Grid;
import com.game.network.Network;

public class NetworkTest {

	@Test
	public void test() {
		Grid grid = new Grid(7, 6);
		Network network = new Network(grid);

	}

}
