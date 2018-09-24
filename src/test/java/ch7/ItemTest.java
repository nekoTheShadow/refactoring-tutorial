package ch7;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemTest {

	@Test
	@DisplayName("toStringのテスト")
	public void testToString() {
		var book = new Item(ItemType.BOOK , "世界の歴史", 4800);
		assertThat(book.toString()).isEqualTo("[ 0, 世界の歴史, 4800 ]");
		
		var dvd = new Item(ItemType.DVD, "ニューヨークの夢・特別版", 3000);
		assertThat(dvd.toString()).isEqualTo("[ 1, ニューヨークの夢・特別版, 3000 ]");
	}

}
