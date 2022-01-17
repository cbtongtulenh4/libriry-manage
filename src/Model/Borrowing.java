package Model;

import java.util.List;

public class Borrowing {

	private String brwId;
	private Employee employee;
	private int total;
	private Reader reader;
	private List<BookState> states;

	public Borrowing() { }

	public Borrowing addFromKeyBoard() {
		// TODO - implement Borrowing.addFromKeyBoard
		throw new UnsupportedOperationException();
	}

	public void show(int Borrowing) {
		// TODO - implement Borrowing.show
		throw new UnsupportedOperationException();
	}

	public String getBrwId() {
		return this.brwId;
	}

	public void setBrwId(String brwId) {
		this.brwId = brwId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Reader getReader() {
		return this.reader;
	}

	public void setReader(Reader person) {
		this.reader = person;
	}

	public List<BookState> getStates() {
		return this.states;
	}

	public void setStates(List<BookState> states) {
		this.states = states;
	}

}