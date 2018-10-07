package ch12;

import java.util.function.Supplier;

public enum GraphType {
	Rectangle(RectangleGraph::new),
	Circle(CircleGraph::new);
	
	private Supplier<? extends Graph> initializer;
	private GraphType(Supplier<? extends Graph> initializer) {
		this.initializer = initializer;
	}
	
	public Graph getGraphInstance() {
		return initializer.get();
	}
}
