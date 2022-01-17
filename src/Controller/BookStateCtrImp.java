package Controller;

import DAO.BookDAOImp;
import DAO.Check;
import Model.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookStateCtrImp extends BookCtrImp {

	Scanner cin = new Scanner(System.in);

	@Override
	public BookState createObject() {
		BookState bs = new BookState();
		System.out.println("\n\tEnter_Information's_BookState: ");
		System.out.print("\t\t- BookID: ");
		boolean check = true;
		do{
			bs.setBookId(cin.nextLine());
			String regex = "^BK_\\d{4}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(bs.getBookId());
			if(matcher.find()
					&& !new Check().checkID(bs.getBookId(),"Book")){
				bs.setBook(new BookDAOImp().takeBook(bs.getBookId()));
				check = false;
			}
			else System.out.print("\tYou_Can_Try_Again: ");
		}while(check);
		System.out.print("\t\t- Quantity_Borrow: ");
		bs.setQuantity(Integer.parseInt(cin.nextLine()));
		System.out.print("\t\t- State: ");
		bs.setState(cin.nextLine());
		return bs;
	}

	public void showObject(BookState Obj) {
		// TODO - implement BookStateCtrImp.showObject
		throw new UnsupportedOperationException();
	}

	public static void main(String[] argv){
		new BookStateCtrImp().createObject();
	}

}