package Controller;

import DAO.Check;
import Model.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeCtrImp extends PersonCtrImp {

	public Employee createObject() {
		//throw new UnsupportedOperationException();
		Employee el = new Employee(new PersonCtrImp().createObject(1));
		System.out.println("Enter_Information's_Employee: ");
		System.out.print("\t- Employee_ID(EL_xxxx): ");
		boolean checkID = true;
		do{
			el.setEmId(cin.nextLine());
			String regex = "^EL_\\d{4}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(el.getEmId());
			if(new Check().checkInID(el.getEmId(),"Employee") && matcher.find())
				checkID = false;
			else System.out.print("You_Can_Try_Again: ");
		}while(checkID);
		System.out.print("\t- Role: ");
		el.setRole(cin.nextLine());
		System.out.print("\t- Shift: ");
		el.setShift(cin.nextLine());
		return el;
	}

	public void showObject(Employee Obj) {
		// TODO - implement EmployeeCtrImp.showObject
		throw new UnsupportedOperationException();
	}

}