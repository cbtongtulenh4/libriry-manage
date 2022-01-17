package Model;

import java.sql.Date;

public class Bill {

	private String billId;
	private Borrowing borrowing;
	private Date startDate;
	private Date dueDate;
	private float deposit;
	public Bill() {

	}

	public String getBillId() {
		return this.billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public float getDeposit() {
		return this.deposit;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}

	public Borrowing getBorrowing() {
		return this.borrowing;
	}

	public void setBorrowing(Borrowing borrowing) {
		this.borrowing = borrowing;
	}

}