package ch4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelTest {	
	
	private Label label;
	
	@BeforeEach
	public void setUp() {
		this.label = new Label("Andrew");
	}
	
	@Test
	@DisplayName("displayのテスト")
	public void testDisplay() {
		assertThat(label.display()).isEqualTo("display: Andrew");
	}
	
	@Test
	@DisplayName("toStringのテスト")
	public void testToString() {
		assertThat(label.toString()).isEqualTo("\"Andrew\"");
	}
	
	@Test
	@DisplayName("isNullのテスト")
	public void testIsNull() {
		assertThat(label.isNull()).isFalse();
	}

}
