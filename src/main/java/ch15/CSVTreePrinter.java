package ch15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CSVTreePrinter extends CSVPrinter {

	protected CSVTreePrinter(CSVReader reader) {
		super(reader);
	}

	@Override
	public String print() throws IOException {
		var tokens = new ArrayList<String>();
		String[] cols;
		while ((cols = reader.readCSV()) != null) {
			for (int i = 0; i < cols.length; i++) {
				tokens.add(String.join("", Collections.nCopies(i * 2, " ")) + cols[i]); 
			}
		}
		return String.join(System.lineSeparator(), tokens);
	}

}
