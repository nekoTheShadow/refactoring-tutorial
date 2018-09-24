package ch9;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoggerTest {
	
	private Logger logger;
	
	@BeforeEach
	public void setUp() {
		this.logger = new Logger();
	}

	@Test
	@DisplayName("インスタンス生成時はSTOPPED状態であることの確認")
	public void createStoppedLogger() {
		assertThat(logger.log("Andrew")).isEqualTo("Ignoring: Andrew");
		assertThat(logger.stop()).isEmpty();
	}
	
	@Test
	@DisplayName("LOGGING状態のロガーに関するテスト")
	public void testLoggingLogger() {
		logger.start();
		assertThat(logger.log("Andrew")).isEqualTo("Logging: Andrew");
		assertThat(logger.start()).isEmpty();
	}

	@Test
	@DisplayName("STOPPED状態とLOGGING状態の遷移のテスト")
	public void stoppedAndLogging() {
		assertThat(logger.log("TEST")).isEqualTo("Ignoring: TEST");
		assertThat(logger.start()).isEqualTo("*** START LOGGING ***");
		assertThat(logger.log("TEST")).isEqualTo("Logging: TEST");
		assertThat(logger.stop()).isEqualTo("*** STOP LOGGING ***");
		assertThat(logger.log("TEST")).isEqualTo("Ignoring: TEST");
	}

}
