package ch2;

import java.util.Arrays;

public class FindInt {
	public static boolean find(int[] data, int target) {
		return Arrays.stream(data).anyMatch(i -> i == target);
	}
}
