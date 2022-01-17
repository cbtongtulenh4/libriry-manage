package Controller;

import DAO.Check;
import DAO.PersonDAOImp;
import Model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonCtrImp {// implements Ctr<Person> {

	Scanner cin = new Scanner(System.in);

	public Person createObject(int left) {
		Person ps = new Person();
		System.out.println("Enter_Information's_Person: ");
		System.out.print("\t- Person_ID: ");
		boolean checkID = true;
		do{
			ps.setId(cin.nextLine());
			String regex = "^\\d{5}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(ps.getId());
			if(matcher.find()){
				if(left == 1 && !new Check().checkInID(ps.getId(),"Person")){
					System.out.println("This_Person:");
					ps = new PersonDAOImp().takeObject(ps.getId());
					System.out.println("Person_ID   FullName                 Address        Gender  Date_OF_Birth");
					showObject(ps);
					return ps;
				}
				else if(new Check().checkInID(ps.getId(),"Person"))
					checkID = false;
			}
			if(checkID) System.out.print("You_Can_Try_Again: ");
		}while(checkID);
		System.out.print("\t- FullName: ");
		ps.setFullName(cin.nextLine());
		System.out.print("\t- Address: ");
		ps.setAddress(cin.nextLine());
		System.out.print("\t- Gender: ");
		ps.setGender(cin.nextLine());
		System.out.print("\t- Date_Of_Birth(dd/MM/yyyy): ");
		do{
			String birth = cin.nextLine();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date date = simpleDateFormat.parse(birth);
				ps.setDob(new java.sql.Date(date.getTime()));
				checkID = false;
			} catch (ParseException e) {
				e.printStackTrace();
				checkID = true;
			}
			if(checkID)	System.out.print("You_Can_Try_Again: ");
		}while(checkID);
		if(left == 1) new PersonDAOImp().appendObject(ps);
		return ps;
	}

	public void showObject(Person obj) {
		//throw new UnsupportedOperationException();
		System.out.printf("%-12s%-25s%-15s%-8s%-12s\n",obj.getId(),obj.getFullName(),
				obj.getAddress(),obj.getGender(),
				new SimpleDateFormat("dd/MM/yyyy").format(obj.getDob()));
	}

	public static void main(String[] argv){
		PersonDAOImp pdi = new PersonDAOImp();
		pdi.appendObject(new PersonCtrImp().createObject(0));
//		Person ps = new Person();
//		new PersonCtrImp().showObject(pdi.takeObject("40001",ps));
//		ps = pdi.takeObject("40001",ps);
//		System.out.println(ps.getFullName());
//
//		var conn = new DBConnection().getDBConnection();
//		String sql = "select FullName from Person where ID = 40001";
//		try {
//			var statement = conn.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			rs.next();
//			System.out.println(rs.getString(1));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

}