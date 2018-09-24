package ch6;

public class Book {
	private String title;
	private String isbn;
	private String price;
	private Author author;
	
	public Book(String title, String isbn, String price, String authorName, String authorMail) {
		this.title = title;
		this.isbn = isbn;
		this.price = price;
		this.author = new Author(authorName, authorMail);
	}
	
	public String toXML() {
		var authorTag = tag("author", tag("name", author.getName()) + tag("mail", author.getMail()));
		var book = tag("book", tag("title", title) + tag("isbn", isbn) + tag("price", price) + authorTag);
		return book;
	}
	
	private String tag(String element, String content) {
		return String.format("<%s>%s</%s>", element, content, element);
	}
}
