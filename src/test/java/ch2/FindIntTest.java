package ch2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FindIntTest {

	@Test
	@DisplayName("findのテスト")
	public void testFind() {
		var data = new int[]{0, 1, 2, 3};
		assertThat(FindInt.find(data, 2)).isTrue();
		assertThat(FindInt.find(data, 5)).isFalse();
	}

}
