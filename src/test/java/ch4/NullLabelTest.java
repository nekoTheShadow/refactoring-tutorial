package ch4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NullLabelTest {
	
	private Label label;
	
	@BeforeEach
	public void setUp() {
		this.label = new NullLabel();
	}
	
	@Test
	@DisplayName("displayのテスト")
	public void testDisplay() {
		assertThat(label.display()).isEmpty();
	}
	
	@Test
	@DisplayName("toStringのテスト")
	public void testToString() {
		assertThat(label.toString()).isEqualTo("\"(none)\"");
	}
	
	@Test
	@DisplayName("isNullのテスト")
	public void testIsNull() {
		assertThat(label.isNull()).isTrue();
	}
}
