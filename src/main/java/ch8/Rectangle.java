package ch8;

public class Rectangle extends Shape {

	protected Rectangle(int startX, int startY, int endX, int endY) {
		super(startX, startY, endX, endY);
	}

	@Override
	public int getTypeCode() {
		return 1;
	}

	@Override
	public String getName() {
		return "RECTANGLE";
	}

	@Override
	protected String draw() {
		return "drawRectangle: " + this.toString();
	}
}
