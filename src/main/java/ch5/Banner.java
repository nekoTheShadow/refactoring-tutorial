package ch5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banner {
	private String content;
	
	public Banner(String content) {
		this.content = content;
	}
	
	public String print(int times) {
		var lines = new ArrayList<String>();
		lines.add(printBorder());
		lines.addAll(printContent(times));
		lines.add(printBorder());
		return String.join(System.lineSeparator(), lines);
	}
	
	private String printBorder() {
		return "+" + String.join("", Collections.nCopies(content.length(), "-")) + "+";
	}
	
	private List<String> printContent(int times) {
		return Collections.nCopies(times, "|" + content + "|");
	}
}
