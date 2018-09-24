package ch6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookTest {

	@Test
	@DisplayName("toXMLのテスト")
	public void testToXML() {
		var book = new Book("プログラマの数学", "ISBN4797329734", "\\2310", "結城浩", "hyuki@hyuki.com");
		assertThat(book.toXML()).isEqualTo(""
				+ "<book>"
				+   "<title>プログラマの数学</title>"
				+   "<isbn>ISBN4797329734</isbn>"
				+   "<price>\\2310</price>"
				+   "<author>"
				+   "<name>結城浩</name>"
				+     "<mail>hyuki@hyuki.com</mail>"
				+   "</author>"
				+ "</book>");
	}

}
