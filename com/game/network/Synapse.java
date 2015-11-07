package com.game.network;

import com.game.connect4.State;

public class Synapse extends NetworkObject {

	private boolean hasOutputConnection;
	private State state;

	@Override
	public boolean isAvailable() {
		return !hasOutputConnection;
	}

	@Override
	public int propagateSignal() {
		// TODO Auto-generated method stub
		return 0;
	}

}
