package ch10;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Robot {

	private String name;
	private Position position = new Position(0, 0);
	private Direction direction = new Direction(0, 1);
	
	public Robot(String name) {
		this.name = name;
	}
	
	public void executeCommand(String command) throws InvalidCommandException {
		this.executeCommand(Command.parseCommand(command));
	}
	
	public void execute(String commandSequence) throws InvalidCommandException {
		var commands = Arrays.stream(commandSequence.split(" ")).map(Command::parseCommand).collect(Collectors.toList());
		commands.forEach(this::executeCommand);
	}
	
	private void executeCommand(Command command) {
		command.executeCommand(this);
	}
	
	public void forward() {
		position.relativeMove(direction.getX(), direction.getY());
	}
	
	public void backward() {
		position.relativeMove(-direction.getX(), -direction.getY());
	}
	
	public void right() {
		direction.setDirection(direction.getY(), -direction.getX());
	}
	
	public void left() {
		direction.setDirection(-direction.getY(), direction.getX());
	}
	
	@Override
	public String toString() {
		return String.format("[ Robot: %s position(%d, %d), direction(%d, %d) ]", 
			name,
			position.getX(), position.getY(),
			direction.getX(), direction.getY());
	}
}
