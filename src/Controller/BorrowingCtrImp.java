package Controller;

import DAO.Check;
import DAO.EmployeeDAOImp;
import DAO.ReaderDAOImp;
import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BorrowingCtrImp implements Ctr<Borrowing> {

	Scanner cin = new Scanner(System.in);

	public String InputID(String regex, String tableName, int way){
		String id;
		boolean checkLoop = true;
		do{
			id = cin.nextLine();
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(id);
			if(matcher.find()){
				if((way == 1 && new Check().checkInID(id,tableName))||
						(way == 0 && !new Check().checkID(id,tableName)))
					checkLoop = false;
			}
			if(checkLoop) System.out.print("Error! You_Can_Try_Again: ");
		}while(checkLoop);
		return id;
	}

	public Borrowing createObject() {
		//throw new UnsupportedOperationException();
		Borrowing borrow = new Borrowing();
		System.out.println("Enter_Information's_Borrowing: ");
		System.out.print("\t- BorrowingID( BR_xxx ): ");
		borrow.setBrwId(InputID("^BR_\\d{3}$","Borrowing",1));
		System.out.print("\t- Reader_ID( RD_xxxx ): ");
		borrow.setReader(new ReaderDAOImp().
				takeObject(InputID("^RD_\\d{4}$","Reader",0)));
		System.out.print("\t- Employee_ID( EL_xxxx ): ");
		borrow.setEmployee(new EmployeeDAOImp().
				takeObject(InputID("^EL_\\d{4}$","Employee",0)));
		System.out.print("\t- Title's_Book: ");
		boolean check = true;
		int choice;
		List<BookState> list = new ArrayList<>();
		while(check){
			list.add(new BookStateCtrImp().createObject());
			System.out.println("Do_You_Wanna_Import_More ?");
			System.out.println("1. Yes\t||\t2.No");
			System.out.print("Choice: ");
			choice = cin.nextInt();
			if(choice == 2) check = false;
		}
		borrow.setStates(list);
		int total = 0;
		for(var i : list){
			total += i.getQuantity();
		}
		borrow.setTotal(total);
		return borrow;
	}


	public void showObject(Borrowing Obj) {
		// TODO - implement BorrowingCtrImp.showObject
		throw new UnsupportedOperationException();
	}

	public static void main(String[] args) {
		new BorrowingCtrImp().createObject();
	}

}