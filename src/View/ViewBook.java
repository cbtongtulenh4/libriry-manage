package View;

import Controller.BookCtrImp;
import DAO.BookDAOImp;

import java.util.Scanner;

public class ViewBook {

    public void actionBook(){
        System.out.println("==============Book==============");
        System.out.println(" 1. Append_Book");
        System.out.println(" 2. Show_Book");
        System.out.println("================================");
        System.out.print("Enter_Your_Choice: ");
        int choice;
        var dao = new BookDAOImp();
        boolean checkLoop = true;
        while(checkLoop){
            choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1 -> dao.appendObject(new BookCtrImp().createObject());
                case 2 -> {
                   // dao.showBook();
                }
                default -> {
                    System.out.println("End_Action_Book");
                    checkLoop = false;
                }
            }
            if(checkLoop) System.out.print("New_Choice_Book: ");
        }
    }

    public static void main(String[] args) {
        BookDAOImp x = new BookDAOImp();
        x.appendObject(new BookCtrImp().createObject());
    }
}