package ch14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import util.RefactoringRuntimeException;

public class AddressFile {
	private Properties properties;
	private Path path;
	
	public AddressFile(Path path) {
		this.path = path;
		this.properties = new Properties();
	}
	
	public void set(String key, String value) {
		properties.setProperty(key, value);
	}
	
	public Optional<String> get(String key) {
		return Optional.ofNullable(properties.getProperty(key));
	}
	
	public Set<String> names() {
		return properties.keySet().stream().map(String::valueOf).collect(Collectors.toSet());
	}
	
	public void update() {
		try (var out = Files.newOutputStream(path)) {
			properties.store(out, null);
		} catch (IOException e) {
			throw new RefactoringRuntimeException(e);
		}
	}
}
