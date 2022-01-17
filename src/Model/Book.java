package Model;

public class Book extends Document {

	private String bookId;
	private String type;

	public Book() {

	}

	public void setDocument(Document x){
		setId(x.getId());
		setAuthor(x.getAuthor());
		setPublishedYear(x.getPublishedYear());
		setQuantity(x.getQuantity());
		setTitle(x.getTitle());
	}

	public String getBookId() {
		return this.bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}