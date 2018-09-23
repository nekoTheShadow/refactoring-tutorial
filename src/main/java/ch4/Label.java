package ch4;

public class Label {

	private String label;

	public Label(String label) {
		this.label = label;
	}

	public String display() {
		return "display: " + label;
	}
	
	@Override
	public String toString() {
		return String.format("\"%s\"", label);
	}
	
	public boolean isNull() {
		return false;
	}
}
