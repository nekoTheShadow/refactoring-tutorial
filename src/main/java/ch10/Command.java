package ch10;

public enum Command {
	Forward {
		@Override
		public void executeCommand(Robot robot) {
			robot.forward();
		}
	},
	Backward {
		@Override
		public void executeCommand(Robot robot) {
			robot.backward();
		}
	},
	Right {
		@Override
		public void executeCommand(Robot robot) {
			robot.right();
		}
	},
	Left {
		@Override
		public void executeCommand(Robot robot) {
			robot.left();
		}
	};
	
	public abstract void executeCommand(Robot robot);
	
	public static Command parseCommand(String command) {
		try {
			return Command.valueOf(command);
		} catch (IllegalArgumentException e) {
			throw new InvalidCommandException();
		}
	}
}
