package View;

import Controller.BorrowingCtrImp;
import DAO.BorrowingDAOImp;

import java.util.Scanner;

public class ViewBorrowing {

    public void actionBorrowing(){
        System.out.println("==========Action_Borrowing=============");
        System.out.println(" 1. Append_Borrowing");
        System.out.println(" 2. Show_List_Borrowing");
        System.out.println(" 3. Sort_By_Name_Reader");
        System.out.println(" 4. Sort_By_Total_Book");
        System.out.println("=======================================");
        System.out.print("Enter_Your_Choice: ");
        int choice;
        var dao = new BorrowingDAOImp();
        boolean checkLoop = true;
        while(checkLoop){
            choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1 -> dao.appendObject(new BorrowingCtrImp().createObject());
                case 2 -> dao.showBorrowing();
                default -> {
                    System.out.println("End_Action_Borrowing");
                    checkLoop = false;
                }
            }
            if(checkLoop) System.out.print("New_Choice_Borrowing: ");
        }
    }

    public static void main(String[] argv){

    }
}