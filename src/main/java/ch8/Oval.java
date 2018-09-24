package ch8;

public class Oval extends Shape {

	protected Oval(int startX, int startY, int endX, int endY) {
		super(startX, startY, endX, endY);
	}

	@Override
	public int getTypeCode() {
		return 2;
	}

	@Override
	public String getName() {
		return "OVAL";
	}

	@Override
	public String draw() {
		return "drawOval: " + this.toString();
	}

}
