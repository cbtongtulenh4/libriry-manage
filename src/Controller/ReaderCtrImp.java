package Controller;

import DAO.Check;
import DAO.ReaderDAOImp;
import Model.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderCtrImp extends PersonCtrImp {

	Scanner cin = new Scanner(System.in);

	public Reader createObject() {
		//throw new UnsupportedOperationException();
		Reader rd = new Reader(new PersonCtrImp().createObject(1));
		System.out.println("Enter_Information's_Reader: ");
		System.out.print("\t- Reader_ID(RD_xxxx): ");
		boolean checkID = true;
		do{
			rd.setReaderId(cin.nextLine());
			String regex = "^RD_\\d{4}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(rd.getReaderId());
			if(new Check().checkInID(rd.getReaderId(),"Reader") && matcher.find())
				checkID = false;
			else System.out.print("You_Can_Try_Again: ");
		}while(checkID);
		System.out.print("\t- Kind_Of_Reader: ");
		rd.setKindOfReader(cin.nextLine());
		System.out.print("\t- Email: ");
		rd.setEmail(cin.nextLine());
		System.out.print("\t- Phone_Number: ");
		rd.setPhoneNumber(cin.nextLine());
		return rd;
	}

	public void showObject(Reader obj) {
		//throw new UnsupportedOperationException();
		System.out.println("Reader_ID   Person_ID   Kind_OF_Reader  Email                    Phone_Number");
		System.out.format("%-12s%-12s%-16s%-25s%-15s\n",obj.getReaderId(),obj.getId(),
				obj.getKindOfReader(),obj.getEmail(),obj.getPhoneNumber());
	}

	public static void main(String[] args) {
		ReaderCtrImp rci = new ReaderCtrImp();
		Reader rd = rci.createObject();
		new ReaderDAOImp().appendObject(rd);
		rci.showObject(rd);
	}

}