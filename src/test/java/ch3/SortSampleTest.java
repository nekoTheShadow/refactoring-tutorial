package ch3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SortSampleTest {
	
	private SortSample sorter;
	
	@BeforeEach
	public void setUp() {
		this.sorter = new SortSample(new int[] {3, 1, 2});
	}
	
	@Test
	@DisplayName("toStringのテスト")
	public void testToString() {
		assertThat(sorter.toString()).isEqualTo("[ 3, 1, 2]");
	}

	@Test
	@DisplayName("sortのテスト")
	public void testSort() {
		sorter.sort();
		assertThat(sorter.toString()).isEqualTo("[ 1, 2, 3]");
	}
}
