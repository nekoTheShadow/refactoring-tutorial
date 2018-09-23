package ch2.q2;

import java.util.ArrayList;
import java.util.List;

public class PointSet {
	private List<Point> points = new ArrayList<>();
	
	public void add(Point point) {
		this.points.add(point);
	}
	
	public boolean existPoint(int x, int y) {
		return points.stream().anyMatch(point -> point.getX() == x && point.getY() == y);
	}
}
