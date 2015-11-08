package com.game.network;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

public class NetworkScreen {
	private static final int SP = 40; //Node pixel spacing
	private BufferedImage image;

	public NetworkScreen(int width, int height) {
		image = new BufferedImage(NetworkVisualizer.GUI_WIDTH, NetworkVisualizer.GUI_HEIGHT, BufferedImage.TYPE_INT_RGB);
	}

	public void update(List<Node> nodes) { //replace maxlayers with layercounts
		Graphics g = image.getGraphics();

		for (Node n : nodes) {
			int xNodeCoord = SP * n.getLayerNum();
			int yNodeCoord = SP * n.getLayerHeight();

			g.drawOval(xNodeCoord, yNodeCoord, SP / 2, SP / 2); //Drawing nodes

			for (Connection c : n.getOutputConnections()) {
				int xConCoord = SP * nodes.get(c.getEndIndex()).getLayerNum();
				int yConCoord = SP * (nodes.get(c.getEndIndex()).getLayerHeight()); //wow that's a mouthful. Can this be done more efficiently?
				g.drawLine(xNodeCoord + (SP / 2), yNodeCoord + (SP / 4), xConCoord, yConCoord + (SP / 4));
			}
		}
		g.drawImage(image, 0, 0, null);
	}

	public BufferedImage getImage() {
		return image;
	}
}
