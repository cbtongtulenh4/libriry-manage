package View;

import Controller.EmployeeCtrImp;
import DAO.Check;
import DAO.EmployeeDAOImp;

import java.util.Scanner;

public class ViewEmployee {

    private final Check check = new Check();
    Scanner cin = new Scanner(System.in);

    public void actionEmployee() {
        EmployeeDAOImp daoImp = new EmployeeDAOImp();
        System.out.println("_________Employee_________");
        System.out.println("1. Show_List_Employee");
        System.out.println("2. Append_Employee");
        System.out.println("3. Edit_Employee");
        System.out.println("4. Remove_Employee");
        System.out.println("5. Find_Employee");
        System.out.println("________________________");
        System.out.print("Enter_Your_Choice: ");
        boolean checkLoop = true;
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    daoImp.showEmployee();
                    break;
                case 2:
                    daoImp.appendObject(new EmployeeCtrImp().createObject());
                    break;
                case 3:
                    System.out.print("Enter_DocumentID_Need_Edit: ");
                    daoImp.editObject(cin.nextLine());
                    break;
                case 4:
                    System.out.print("Enter_ReaderID_Need_Remove: ");
                    daoImp.removeObject(check.checkOutID(cin.nextLine(), "Reader"));
                    break;
                case 5:
                    // FindReader(daoImp);
                    break;
                default:
                    System.out.println("End_Action_With_Reader");
                    checkLoop = false;
                    break;
            }
            if (checkLoop) System.out.print("Enter_New_Choice: ");
        } while (checkLoop);
    }
}