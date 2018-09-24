package ch5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BannerTest {

	@Test
	@DisplayName("printのテスト")
	public void testPrint() {
		var lines = List.of(
			"+-----+",
			"|Hello|",
			"|Hello|",
			"|Hello|",
			"+-----+"
		);
		var text = String.join(System.lineSeparator(), lines);
		
		var banner = new Banner("Hello");
		assertThat(banner.print(3)).isEqualTo(text);
	}

}
