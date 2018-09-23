package ch4;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person {
	
	private Label name;
	private Label mail;

	public Person(Label name, Label mail) {
		this.name = name;
		this.mail = mail;
	}
	
	public Person(Label name) {
		this.name = name;
		this.mail = new NullLabel();
	}
	
	public String display() {
		return Stream.of(name, mail)
			.filter(label -> !label.isNull())
			.map(Label::display)
			.collect(Collectors.joining(", "));
	}
	
	@Override
	public String toString() {
		return String.format("[ Person: name=%s mail=%s ]", name, mail);
	}
}
