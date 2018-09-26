package ch15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVFileReader extends CSVReader {
	public CSVFileReader(Path file) throws IOException {
		super(Files.newBufferedReader(file));
	}
}
