package ch2.q2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointSetTest {
	@Test
	@DisplayName("existPointのテスト")
	public void testExistPoint() {
		var points = new PointSet();
		points.add(new Point(1, 2));
		points.add(new Point(3, 4));
		
		assertThat(points.existPoint(3, 4)).isTrue();
		assertThat(points.existPoint(8, 9)).isFalse();
	}
}
