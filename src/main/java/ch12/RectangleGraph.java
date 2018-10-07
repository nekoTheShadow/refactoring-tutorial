package ch12;

import java.awt.Color;
import java.awt.Graphics;

public class RectangleGraph extends Graph {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void paint(Graphics g) {
		g.setColor(graphValue > 0 ? Color.BLUE : Color.RED);
		var bounds = getBounds();
		int x, y, w, h;
		if (graphValue > 0) {
			w = (int) (bounds.width / 2 * graphValue / 100.0);
			h = bounds.height / 2;
			x = bounds.width / 2;
			y = bounds.height / 4;
		} else {
			w = (int) (bounds.width / 2 * -graphValue / 100.0);
			h = bounds.height / 2;
			x = bounds.width / 2 - w;
			y = bounds.height / 4;
		}
		g.fillRect(x, y, w, h);
	}
}
