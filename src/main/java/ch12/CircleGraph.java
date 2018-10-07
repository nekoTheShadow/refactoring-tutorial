package ch12;

import java.awt.Color;
import java.awt.Graphics;

public class CircleGraph extends Graph {
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		g.setColor(graphValue > 0 ? Color.BLUE : Color.RED);
		var bounds = getBounds();
		int startAngle = 90;
		int endAngle = -(int)(graphValue * 10.0);
		g.fillArc(0, 0, bounds.width, bounds.height, startAngle, endAngle);
	}
}
