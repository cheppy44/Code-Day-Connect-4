package com.game.network;

public abstract class NetworkObject {

	abstract boolean isAvailable();

	abstract int propagateSignal(); //Network cycles through all nodes and propagates
}
