package com.game.evolution;

import com.game.network.Network;

public abstract class Mutator {
	public Network mutate(Network network) {
		Network mutated = network;

		return mutated; //After mutation takes place
	}

	public void mutateThreshold(Node n) {

	}

	public void mutateWeights(Connection c) {

	}
}
