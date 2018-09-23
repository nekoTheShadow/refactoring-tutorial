package ch4;

public class NullLabel extends Label {

	public NullLabel() {
		super("(none)");
	}
	
	@Override
	public String display() {
		return "";
	}
	
	@Override
	public boolean isNull() {
		return true;
	}
}
