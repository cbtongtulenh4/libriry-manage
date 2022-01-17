package Model;

public class Reader extends Person {

	private String readerId;
	private String kindOfReader;
	private String email;
	private String phoneNumber;

	public Reader() {
		// TODO - implement Reader.Reader
		//throw new UnsupportedOperationException();
	}

	public Reader(Person x){
		super(x);
	}

	public String getReaderId() {
		return this.readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public String getKindOfReader() {
		return this.kindOfReader;
	}

	public void setKindOfReader(String kindOfReader) {
		this.kindOfReader = kindOfReader;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


}