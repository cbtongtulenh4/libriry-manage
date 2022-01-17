package Controller;

import DAO.Check;
import DAO.DocumentDAOImp;
import Model.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookCtrImp extends DocumentCtrImp {

	public Book createObject() {
		Book book = new Book();
		System.out.print("\t- DocumentID: ");
		boolean check = true;
		do{
			book.setId(cin.nextLine());
			String regex = "^[a-zA-z]{2}_\\d{3}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(book.getId());
			if(matcher.find() && !new Check().checkID(book.getId(),"Document")){
					book.setDocument(new DocumentDAOImp().takeDocument(book.getId()));
					check = false;
			}
			else System.out.print("You_Can_Try_Again: ");
		}while(check);
		System.out.print("\t- BookID( BK_xxxx ): ");
		check = true;
		do{
			book.setBookId(cin.nextLine());
			String regex = "^BK_\\d{4}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(book.getBookId());
			if(matcher.find() && new Check().checkInID(book.getBookId(),"Book")){
				check = false;
			}
			else System.out.print("You_Can_Try_Again: ");
		}while(check);
		System.out.println("\t- Type: ");
		final String[] genre = {"Humorous", "Romantic", "detective", "Supernatural"};
		for(int i = 0; i < genre.length;i++){
			System.out.print(i + "." + genre[i] + "\t");
		}
		System.out.print("Choice: ");
		int choice = cin.nextInt();
		book.setType(genre[choice]);
		return book;
	}

	public void showObject(Book Obj) {
		// TODO - implement BookCtrImp.showObject
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		BookCtrImp bookCtrImp = new BookCtrImp();
		bookCtrImp.createObject();
	}

}