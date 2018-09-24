package ch8;

public class Line extends Shape {

	protected Line(int startX, int startY, int endX, int endY) {
		super(startX, startY, endX, endY);
	}

	@Override
	public int getTypeCode() {
		return 0;
	}

	@Override
	public String getName() {
		return "LINE";
	}

	@Override
	public String draw() {
		return "drawLine: " + this.toString();
	}
}
