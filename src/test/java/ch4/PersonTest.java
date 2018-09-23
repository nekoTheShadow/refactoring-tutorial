package ch4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonTest {

	@Test
	@DisplayName("コンストラクタPerson(Label, Label)でインスタンスを生成した場合")
	public void testConstructorWithTwoArguments() {
		var person = new Person(new Label("Alice"), new Label("alice@example.com"));
		assertThat(person.display()).isEqualTo("display: Alice, display: alice@example.com");
		assertThat(person.toString()).isEqualTo("[ Person: name=\"Alice\" mail=\"alice@example.com\" ]");
	}
	
	@Test
	@DisplayName("コンストラクタPerson(Label)でインスタンスを生成した場合")
	public void testConstructorWithOneArguments() {
		var person = new Person(new Label("Alice"));
		assertThat(person.display()).isEqualTo("display: Alice");
		assertThat(person.toString()).isEqualTo("[ Person: name=\"Alice\" mail=\"(none)\" ]");
	}
}
