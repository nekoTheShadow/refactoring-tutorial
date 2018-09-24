package ch10;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CommandTest {

	@ParameterizedTest
	@DisplayName("parseCommandのテスト")
	@MethodSource("arguments")
	public void testParseCommand(Command command, String commandString) {
		assertThat(Command.parseCommand(commandString)).isEqualTo(command);
	}
	
	public static Stream<Arguments> arguments() {
		return Stream.of(
			Arguments.arguments(Command.Forward, "Forward"),
			Arguments.arguments(Command.Backward, "Backward"),
			Arguments.arguments(Command.Left, "Left"),
			Arguments.arguments(Command.Right, "Right")
		);
	}
	
	@Test
	@DisplayName("コマンドの変換ができない場合")
	public void parseUnknownCommand() {
		assertThatThrownBy(() -> Command.parseCommand("Unknown")).isInstanceOf(InvalidCommandException.class);
	}
}
