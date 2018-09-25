package ch13;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiceTest {

	@Test
	@DisplayName("nextIntのテスト")
	public void testNextInt() {
		var random = mock(Random.class);
		when(random.nextInt(6)).thenReturn(1);
		
		var dice = new Dice(random);
		assertThat(dice.nextInt()).isEqualTo(2);
	}

}
