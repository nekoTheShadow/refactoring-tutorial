package ch8;

public abstract class Shape {
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	
	protected Shape(int startX, int startY, int endX, int endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}
	
	@Override
	public String toString() {
		return String.format("[ %s, (%d, %d)-(%d, %d) ]", getName(), startX, startY, endX, endY);
	}
	
	protected abstract int getTypeCode();
	protected abstract String getName();
	protected abstract String draw();
	
	public static Line createLine(int startX, int startY, int endX, int endY) {
		return new Line(startX, startY, endX, endY);
	}
	
	public static Oval createOval(int startX, int startY, int endX, int endY) {
		return new Oval(startX, startY, endX, endY);
	}
	
	public static Rectangle createRectangle(int startX, int startY, int endX, int endY) {
		return new Rectangle(startX, startY, endX, endY);
	}
}
