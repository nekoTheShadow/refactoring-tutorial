package ch10;

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void relativeMove(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
}
