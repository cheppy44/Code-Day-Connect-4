package com.game.unitTests;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.game.connect4.GameRunner;
import com.game.connect4.Grid;
import com.game.connect4.State;
import com.game.network.Network;
import com.game.network.Node;

public class GameRunnerTest extends Mockito {
	GameRunner gameRunner;
	Grid mockGrid = mock(Grid.class);
	Network mockNetwork = mock(Network.class);
	Node mockNode = mock(Node.class);
	List<Node> mockedList = mock(List.class);

	@Test
	public void test() {
		when(mockedList.get(anyInt())).thenReturn(mockNode);
		when(mockNode.calcOutput()).thenAnswer(1);
		when(mockedList.size()).thenReturn(3);
		gameRunner = new GameRunner(mockGrid);
		gameRunner.startTurn(mockNetwork, mockedList, State.red);

		verify(mockNetwork).update();
		verify(mockGrid).dropGamePiece(7, State.red);

	}

}
