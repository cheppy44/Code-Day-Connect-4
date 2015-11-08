package com.game.unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.game.connect4.Grid;
import com.game.network.Network;

public class NetworkTest {

	@Test
	public void test() {
		Grid grid = new Grid(7, 6);
		Network network = new Network(grid);

		for (int i = 0; i < network.getNodes().size(); i++) {
			network.updateNetworkInput();
			assertEquals(network.getNodes().get(i).getNodeIndex(), i);
		}

	}
}
