package ch1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.RefactoringRuntimeException;

public class RobotTest {

	private Robot robot;
	
	@BeforeEach
	public void setUp() {
		this.robot = new Robot("Andrew");
	}
	
	@Test
	@DisplayName("サポートされているCommandのテスト")
	public void supportedCommand() {
		assertThat(robot.order(Command.WALK)).isEqualTo("Andrew walks.");
		assertThat(robot.order(Command.JUMP)).isEqualTo("Andrew jumps.");
		assertThat(robot.order(Command.STOP)).isEqualTo("Andrew stops.");
	}
	
	@Test
	@DisplayName("サポートされていないCommandのテスト")
	public void unsupportedCommand() {
		assertThatThrownBy(() -> robot.order(null))
			.isInstanceOf(RefactoringRuntimeException.class)
			.hasMessage("Unknown Command");
	}
}
