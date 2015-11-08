package com.game.Logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.game.network.Connection;
import com.game.network.Network;
import com.game.network.Node;

public class SpreadsheetLogger {

	static int i;
	private final static String FILE_NAME = "NetworkLog";
	private final static String FILE_LOCATION = FILE_NAME + "." + i + ".csv";

	public static void logToFile(Network network) {
		try {
			BufferedWriter f = new BufferedWriter(new FileWriter(FILE_LOCATION));
			f.write("Network ID");
			f.write(",");
			f.write(network.toString());
			f.write(";");
			f.write("inputNodes");
			f.write(",");
			f.write("" + network.getnumInputs());
			f.write(",");
			f.write("outputNodes");
			f.write(",");
			f.write("" + network.getnumOutputs());
			f.write(",");
			f.write("FitnessLevel");
			f.write(",");
			f.write("" + network.getFitnessLevel());
			f.write(";");

			int x = 0;
			for (Node n : network.getNodes()) {
				f.write("Node Number");
				f.write(",");
				f.write("" + x);
				f.write(";");
				f.write("Node Status");
				f.write(",");
				f.write(n.toString());
				f.write(";");
				f.write("Layer Height");
				f.write(",");
				f.write("" + n.getLayerHeight());
				f.write(";");
				f.write("Layer Number");
				f.write(",");
				f.write("" + n.getLayerNum());
				f.write(";");
				f.write("Connections");
				f.write(";");
				f.write("Number of Connections");
				f.write(",");
				f.write("" + n.getOutputConnections().size());
				f.write(";");
				int j = 0;
				for (Connection c : n.getOutputConnections()) {
					f.write("Connection Number");
					f.write(",");
					f.write("" + j);
					f.write(";");
					f.write("Usage Weight");
					f.write(",");
					f.write("" + c.getUsageWeight());
					f.write(";");
					f.write("output");
					f.write(",");
					f.write("" + c.getOutput());
					f.write(";");
					j++;
				}

			}
			i++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
