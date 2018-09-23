package ch2;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleDatabaseTest {

	private SimpleDatabase db;
	
	@BeforeEach
	public void setUp() throws URISyntaxException, IOException {
		var uri = this.getClass().getClassLoader().getResource("dbfile.txt").toURI();
		this.db = new SimpleDatabase(Paths.get(uri));
	}
	
	@Test
	@DisplayName("UserIDが存在する場合")
	public void knownUserId() {
		assertThat(this.db.getUserId("tomura@example.com")).contains("Tomura");
	}

	@Test
	@DisplayName("UserIDが存在しない場合")
	public void unknownUserId() {
		assertThat(this.db.getUserId("hogehoge@example.com")).isEmpty();
	}
	
	@Test
	@DisplayName("Iteratorにはemailの一覧が含まれる")
	public void testIterator() {
		assertThat(this.db.iterator()).containsExactlyInAnyOrder("hyuki@example.com", "sato@example.com", "tomura@example.com");
	}
}
