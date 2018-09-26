package ch15;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CSVTablePrinterTest {
	
	@ParameterizedTest
	@MethodSource("getArguments")
	@DisplayName("CSVReaderとCSVPrinterの組み合わせテスト")
	public void test(CSVReader reader, Function<CSVReader, CSVPrinter> printer, String expected) {
		try {
			assertThat(printer.apply(reader).print()).isEqualTo(expected);
		} catch (IOException e) {
			fail(e);
		} finally {
			reader.close();
		}
	}
	
	public static Stream<Arguments> getArguments() throws IOException, URISyntaxException {
		var file = Paths.get(CSVTablePrinterTest.class.getClassLoader().getResource("ch15.csv").toURI());
		var string = String.join(System.lineSeparator(), Files.readAllLines(file));
		
		Function<CSVReader, CSVPrinter> tablePrinter = CSVTablePrinter::new;
		Function<CSVReader, CSVPrinter> treePrinter = CSVTreePrinter::new;
		
		var tableResult = String.join(System.lineSeparator(), 
			"<table>",
			"<tr>",
			"<td>good</td>",
			"<td>morning</td>",
			"</tr>",
			"<tr>",
			"<td>hello</td>",
			"<td>world</td>",
			"</tr>",
			"</table>"
		);
		var treeResult = String.join(System.lineSeparator(), 
			"good",
			"  morning",
			"hello",
			"  world"
		);
		
		return Stream.of(
			arguments(new CSVStringReader(string), tablePrinter, tableResult),
			arguments(new CSVStringReader(string), treePrinter, treeResult),
			arguments(new CSVFileReader(file), tablePrinter, tableResult),
			arguments(new CSVFileReader(file), treePrinter, treeResult)
		);
	}
}
