package com.game.unitTesting;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import com.game.network.Connection;
import com.game.network.Network;
import com.game.network.Node;

public class NodeTest extends Mockito {
	Node node;
	Connection connection;

	@Test
	public void test() {
		node = new Node(0, 0);
		Network mockNetwork = mock(Network.class);
		ArrayList<Connection> mockedConnections = new ArrayList<Connection>();
		addConnections(mockedConnections);

		// Weight of 1 and output to all connections
		node.addInputWeight(1);
		node.outputToConnections();

		// Weight of 0.5 and 1 and output to all connections (This shouldn't
		// result in a connection being on)
		node.addInputWeight(0.5);
		node.addInputWeight(1);
		node.outputToConnections();

		for (Connection c : mockedConnections) {
			verify(c, times(1)).setState(true);
		}

	}

	private void addConnections(ArrayList<Connection> mockedConnections) {
		// TODO Auto-generated method stub
		for (int i = 1; 1 <= 3; i++) {
			mockedConnections.add(Mockito.mock(Connection.class));

			node.addConnection(mockedConnections.get(i));
		}

	}
}
