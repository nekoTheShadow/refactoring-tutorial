package ch13;

import java.util.Random;

public class Dice {
	private Random random;
	
	public Dice(Random random) {
		this.random = random;
	}
	
	public int nextInt() {
		return random.nextInt(6) + 1;
	}
}
