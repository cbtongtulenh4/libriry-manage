package Controller;

import DAO.Check;
import Model.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentCtrImp implements Ctr<Document> {

    Scanner cin = new Scanner(System.in);

	public Document createObject() {
        //throw new UnsupportedOperationException();
		Document dcm = new Document();
		boolean checkID = true;
        System.out.println("Enter_Information's_Document: ");
		System.out.print("\t-Code_ID(EZ_354): ");
		do{
		    dcm.setId(cin.nextLine());
		    String regex = "^[a-zA-z]{2}_\\d{3}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(dcm.getId());
            if(matcher.find() && new Check().checkInID(dcm.getId(),"Document"))
                checkID = false;
            else System.out.print("You_Can_Try_Again: ");
        }while(checkID);
        System.out.print("\t-Title: ");
        dcm.setTitle(cin.nextLine());
        System.out.print("\t-Name_Author: ");
        dcm.setAuthor(cin.nextLine());
        System.out.print("\t-PublishedYear: ");
        dcm.setPublishedYear(cin.nextInt());
        System.out.print("\t-Quantity: ");
        dcm.setQuantity(cin.nextInt());
        return dcm;
	}


	public void showObject(Document obj) {
		//throw new UnsupportedOperationException();
        System.out.println("________________________________<Document>________________________________");
        System.out.println("ID        Title                    Author              PublishedYear  Quantity");
        System.out.format("%-10s%-25s%-20s%-15d%-10d\n",obj.getId(),obj.getTitle(),obj.getAuthor(),
                obj.getPublishedYear(),obj.getQuantity());
        System.out.println("______________________________________________________________________________");
	}

}