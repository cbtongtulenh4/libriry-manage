package Model;

public class Employee extends Person {

	private String emId;
	private String role;
	private String shift;

	public Employee() {

	}

	public Employee(Person x) {
		super(x);
	}

	public String getEmId() {
		return this.emId;
	}

	public void setEmId(String emId) {
		this.emId = emId;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getShift() {
		return this.shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

}