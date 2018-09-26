package ch15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVTablePrinter extends CSVPrinter {
	public CSVTablePrinter(CSVReader reader) {
		super(reader);
	}

	@Override
	public String print() throws IOException {
		var tokens = new ArrayList<String>();
		tokens.add("<table>");
		
		String[] cols;
		while ((cols = reader.readCSV()) != null) {
			tokens.add("<tr>");
			Arrays.stream(cols).map(col -> "<td>" + col + "</td>").forEach(tokens::add);
			tokens.add("</tr>");
		}
		
		tokens.add("</table>");
		return String.join(System.lineSeparator(), tokens);
	}
}
