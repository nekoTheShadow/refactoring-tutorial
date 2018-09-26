package ch15;

import java.io.IOException;

public abstract class CSVPrinter {
	protected CSVReader reader;
	protected CSVPrinter(CSVReader reader) {
		this.reader = reader;
	}
	public abstract String print() throws IOException;
}
