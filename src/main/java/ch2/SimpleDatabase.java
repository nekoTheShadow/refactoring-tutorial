package ch2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SimpleDatabase implements Iterable<String> {
	private Map<String, String> userIds;
	
	public SimpleDatabase(Path path) throws IOException {
		this.userIds = Files.lines(path)
			.map(line -> line.split("="))
			.collect(Collectors.toMap(tokens -> tokens[0], tokens -> tokens[1]));
	}

	@Override
	public Iterator<String> iterator() {
		return userIds.keySet().iterator();
	}
	
	public Optional<String> getUserId(String email) {
		return Optional.ofNullable(userIds.get(email));
	}
}
