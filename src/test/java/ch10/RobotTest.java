package ch10;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RobotTest {

	private Robot robot;
	
	@BeforeEach
	public void setUp() {
		this.robot = new Robot("Andrew");
	}
	

	@ParameterizedTest
	@DisplayName("testExecuteのテスト")
	@MethodSource("testExecuteCommandArguments")
	public void testExecuteCommandWithString(String command, String string) {
		robot.executeCommand(command);
		assertThat(robot.toString()).isEqualTo(string);
	}
	
	@Test
	@DisplayName("サポート外のコマンドが与えられた場合")
	public void testUnknownCommand() {
		assertThatThrownBy(() -> robot.executeCommand("unknown")).isInstanceOf(InvalidCommandException.class);
	}
	
	@Test
	@DisplayName("サポート外のコマンドが与えられた場合、ロールバックする。")
	public void testRollBack() {
		var before = robot.toString();
		assertThatThrownBy(() -> robot.execute("Forward Unknown")).isInstanceOf(InvalidCommandException.class);
		assertThat(robot.toString()).isEqualTo(before);
	}
	
	@Test
	@DisplayName("executeのテスト")
	public void testExecute() {
		robot.execute("Forward Right Forward");
		assertThat(robot.toString()).isEqualTo("[ Robot: Andrew position(1, 1), direction(1, 0) ]");
		
		robot.execute("Left Backward Left Forward");
		assertThat(robot.toString()).isEqualTo("[ Robot: Andrew position(0, 0), direction(-1, 0) ]");
	}
	
	public static Stream<Arguments> testExecuteCommandArguments() {
		return Stream.of(
			Arguments.arguments("Forward",  "[ Robot: Andrew position(0, 1), direction(0, 1) ]"),
			Arguments.arguments("Backward", "[ Robot: Andrew position(0, -1), direction(0, 1) ]"),
			Arguments.arguments("Left",     "[ Robot: Andrew position(0, 0), direction(-1, 0) ]"),
			Arguments.arguments("Right",    "[ Robot: Andrew position(0, 0), direction(1, 0) ]")
		);
	}
	
}
