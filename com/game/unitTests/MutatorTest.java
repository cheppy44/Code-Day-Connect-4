package com.game.unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.game.connect4.Grid;
import com.game.evolution.Mutator;
import com.game.network.Network;

public class MutatorTest {
	@Test
	public void test(){
		Grid grid = new Grid(7, 6);
		Network preMutation = new Network(grid);
		Network postMutation = Mutator.mutate(preMutation);
		
		assertNotSame(preMutation, postMutation);
		
	}

}
