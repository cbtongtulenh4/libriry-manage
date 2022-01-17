package View;

import Controller.BillCtrImp;
import DAO.BillDAOImp;

import java.util.Scanner;

public class ViewBill {
    public void actionBill(){
        System.out.println("=============BILL===============");
        System.out.println(" 1. Append_Bill");
        System.out.println(" 2. Show_Bill");
        System.out.println("================================");
        System.out.print("Enter_Your_Choice: ");
        int choice;
        var dao = new BillDAOImp();
        boolean checkLoop = true;
        while(checkLoop){
            choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1 -> dao.appendObject(new BillCtrImp().createObject());
                case 2 -> dao.showBill();
                default -> {
                    System.out.println("End_Action_Bill");
                    checkLoop = false;
                }
            }
            if(checkLoop) System.out.print("New_Choice_Bill: ");
        }
    }
}