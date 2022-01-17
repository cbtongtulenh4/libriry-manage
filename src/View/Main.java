package View;

import Controller.BookCtrImp;
import DAO.BookDAOImp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("_____________________MENU_________________________");
        System.out.println("1. Management_Of_Document_Information");
        System.out.println("2. Management_Of_Reader_Or_Employee_Information");
        System.out.println("3. Management_Of_Borrowing_Information");
        System.out.println("4. Management_Of_Bill_Information");
        System.out.println("==================================================");
        System.out.print("Enter_Your_Choice: ");
        int choice ;
        boolean check = true;
        do {
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1 -> {
                    ViewDocument dcm = new ViewDocument();
                    dcm.actionDocument();
                }
                case 2 -> {
                    System.out.println("__________________Tab<2>_________________");
                    System.out.println("1. Management_Of_Reader_Information");
                    System.out.println("2. Management_Of_Employee_Information");
                    System.out.println("_________________________________________");
                    System.out.print("Your_Choice: ");
                    choice = new Scanner(System.in).nextInt();
                    if (choice == 1) new ViewReader().actionReader();
                    else if (choice == 2) new ViewEmployee().actionEmployee();
                }
                case 3 -> new ViewBorrowing().actionBorrowing();
                case 4 -> new ViewBill().actionBill();
                case 5 -> {
                    BookDAOImp x = new BookDAOImp();
                    x.appendObject(new BookCtrImp().createObject());
                }
                default -> {
                    System.out.println("Thank_You_For_Use");
                    check = false;
                }
            }
            if(check) System.out.print("Enter_New_Choice: ");
        }while(check);

    }
}