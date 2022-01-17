package Controller;

import DAO.BorrowingDAOImp;
import Model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BillCtrImp implements Ctr<Bill> {

	Scanner cin = new Scanner(System.in);

	public java.sql.Date setDateSQL(){
		boolean checkLoop;
		do{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date date = simpleDateFormat.parse(cin.nextLine());
				return new java.sql.Date(date.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("Pattern must \"dd/MM/yyyy\"");
				checkLoop = true;
			}
			if(checkLoop) System.out.print("You_Can_Try_Again: ");
		}while(checkLoop);
		return null;
	}

	public Bill createObject() {
		Bill bill = new Bill();
		System.out.println("Enter_Information's_Bill: ");
		System.out.print("\t- Bill_ID: ");
		bill.setBillId(new BorrowingCtrImp().InputID("^$","Bill",1));
		System.out.print("\t- BorrowingID( BR_xxx ): ");
		bill.setBorrowing(new BorrowingDAOImp().
				takeBorrowing(new BorrowingCtrImp().InputID("^BR_\\d{3}$","Borrowing",0)));
		System.out.print("\t- Start_Date: ");
		bill.setStartDate(setDateSQL());
		System.out.print("\t- Due_Date: ");
		bill.setDueDate(setDateSQL());
		System.out.print("\t- Deposit: ");
		bill.setDeposit(cin.nextFloat());
		return bill;
	}

	public void showObject(Bill Obj) {
		// TODO - implement BillCtrImp.showObject
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		java.sql.Date a = new BillCtrImp().setDateSQL();
		System.out.println(a);
	}

}