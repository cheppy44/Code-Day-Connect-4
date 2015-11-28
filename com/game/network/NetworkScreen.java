package com.game.network;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

public class NetworkScreen {
	private static final int SP = 40; //Node pixel spacing
	private BufferedImage image;

	public NetworkScreen(int width, int height) {
		image = new BufferedImage(NetworkVisualizer.GUI_WIDTH, NetworkVisualizer.GUI_HEIGHT, BufferedImage.TYPE_INT_RGB);
	}

	public void update(List<Node> nodes) { 
		Graphics g = image.getGraphics();

		for (Node n : nodes) {
			int xNodeCoord = SP * n.getLayerNum();
			int yNodeCoord = SP * n.getLayerHeight();
			//g.setColor(Color.WHITE);
			g.drawOval(xNodeCoord, yNodeCoord, SP / 2, SP / 2); //Drawing nodes

			for (Connection c : n.getOutputConnections()) {
				g.setColor(Color.getHSBColor((float) c.getUsageWeight(), 100, 100));
				System.out.println(g.getColor());
				int xConCoord = SP * nodes.get(c.getEndIndex()).getLayerNum();
				int yConCoord = SP * (nodes.get(c.getEndIndex()).getLayerHeight());
				g.drawLine(xNodeCoord + (SP / 2), yNodeCoord + (SP / 4), xConCoord, yConCoord + (SP / 4));
			}
		}
		g.drawImage(image, 0, 0, null);
	}

	public BufferedImage getImage() {
		return image;
	}
}
