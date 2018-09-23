package ch1;

import util.RefactoringRuntimeException;

public class Robot {
	private String name;
	
	public Robot(String name) {
		this.name = name;
	}
	
	public String order(Command command) {
		if (command == Command.WALK) {
			return String.format("%s walks.", name);
		}
		
		if (command == Command.STOP) {
			return String.format("%s stops.", name);
		}
		
		if (command == Command.JUMP) {
			return String.format("%s jumps.", name);
		}
		
		throw new RefactoringRuntimeException("Unknown Command");
	}
}
