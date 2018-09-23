package ch3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortSample {
	
	private int[] digits;
	
	public SortSample(int[] digits) {
		this.digits = new int[digits.length];
		System.arraycopy(digits, 0, this.digits, 0, digits.length);
	}
	
	public void sort() {
		for (int x = 0; x < digits.length - 1; x++) {
			int m = x;
			for (int y = x + 1; y < digits.length; y++) {
				if (digits[m] > digits[y]) {
					m = y;
				}
			}
			
			assert isMin(m, x, digits.length);
			int v = digits[m];
			digits[m] = digits[x];
			digits[x] = v;
			assert isSorted(0, x + 1);
		}
	}

	@Override
	public String toString() {
		return Arrays.stream(digits).mapToObj(Integer::toString).collect(Collectors.joining(", ", "[ ", "]"));
	}
	
	private boolean isMin(int pos, int start, int end) {
		for (int i = start; i < end; i++) {
			if (digits[pos] > digits[i]) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isSorted(int start, int end) {
		for (int i = start; i < end; i++) {
			if (digits[i] > digits[i + 1]) {
				return false;
			}
		}
		return true;
	}
}
