package ch15;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;

public class CSVReader implements Closeable {
	private BufferedReader reader;
	
	protected CSVReader(BufferedReader reader) {
		this.reader = reader;
	}
	
	public String[] readCSV() throws IOException {
		String line = reader.readLine();
		return line == null ? null : line.split(",");
	}
	
	@Override
	public void close() {
		try {
			this.reader.close();
		} catch (IOException e) {
			// PASS
		}
	}
}
