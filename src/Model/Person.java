package Model;

import java.sql.Date;

public class Person {

	private String id;
	private String fullName;
	private String address;
	private String gender;
	private Date dob;

	public Person() {
		// TODO - implement Person.Person
		//throw new UnsupportedOperationException();
	}

	public Person(Person x){
		this.id = x.id;
		this.fullName = x.fullName;
		this.address = x.address;
		this.gender = x.gender;
		this.dob = x.dob;
	}

	public String getId() {
		return this.id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return this.fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return this.address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setPerson(Person x){
		this.id = x.id;
		this.fullName = x.fullName;
		this.address = x.address;
		this.gender = x.gender;
		this.dob = x.dob;
	}

}