package ch14;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddressFileTest {
	
	private Path path;
	private AddressFile addressFile;
	
	@BeforeEach
	public void setUp() throws IOException {
		path = Files.createTempFile(null, null);
		addressFile = new AddressFile(path);
		addressFile.set("Hiroshi Yuki", "hyuki@example.com");
		addressFile.set("Hanako Sato", "hanako@example.com");
	}
	
	@AfterEach
	public void tearDown() throws IOException {
		Files.deleteIfExists(path);
	}

	@Test
	@DisplayName("getのテスト")
	public void testGet() {
		assertThat(addressFile.get("Hiroshi Yuki")).isEqualTo(Optional.of("hyuki@example.com"));
		assertThat(addressFile.get("Tomura")).isEmpty();
	}
	
	@Test
	@DisplayName("updateのテスト")
	public void testUpdate() {
		addressFile.update();
		
		var properties = new Properties();
		try (var in = Files.newInputStream(path)) {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		
		assertThat(properties.getProperty("Hiroshi Yuki")).isEqualTo("hyuki@example.com");
		assertThat(properties.getProperty("Hanako Sato")).isEqualTo("hanako@example.com");
		assertThat(properties.getProperty("Tomura")).isNull();
	}
	
	@Test
	@DisplayName("namesのテスト")
	public void testNames() {
		assertThat(addressFile.names()).containsExactlyInAnyOrder("Hiroshi Yuki", "Hanako Sato");
	}

}
