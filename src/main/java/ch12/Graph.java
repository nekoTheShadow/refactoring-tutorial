package ch12;

import java.awt.Canvas;
import java.awt.Dimension;

public class Graph extends Canvas implements ValueListener {
	private static final long serialVersionUID = 1L;
	
	protected int graphValue;
	
	public static Graph createGraph(GraphType type, int width, int height) {
		var graph = type.getGraphInstance();
		graph.setSize(new Dimension(width, height));
		return graph;
	}
	
	@Override
	public void valueChanged(ValueChangeEvent e) {
		graphValue = e.getSource().getValue();
		repaint();
	}
}
