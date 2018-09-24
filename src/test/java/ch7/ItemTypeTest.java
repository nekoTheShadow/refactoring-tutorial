package ch7;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemTypeTest {

	@Test
	@DisplayName("getTypeCodeのテスト")
	public void testGetTypeCode() {
		assertThat(ItemType.BOOK.getTypeCode()).isEqualTo(0);
		assertThat(ItemType.DVD.getTypeCode()).isEqualTo(1);
		assertThat(ItemType.SOFTWARE.getTypeCode()).isEqualTo(2);
	}

}
