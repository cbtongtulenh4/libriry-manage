package View;

import Controller.DocumentCtrImp;
import DAO.Check;
import DAO.DocumentDAOImp;
import Model.Document;

import java.util.List;
import java.util.Scanner;

public class ViewDocument {

    private final Check check = new Check();
    Scanner cin = new Scanner(System.in);

    public void FindDocument(DocumentDAOImp daoImp){
        Document dcm;// = new Document();
        DocumentCtrImp dci = new DocumentCtrImp();
        System.out.println("____________Find<Document>____________");
        System.out.println("1. Find_Document_By_Title ");
        System.out.println("2. Find_Document_By_ID ");
        System.out.println("3. Find_Document_By_Author ");
        System.out.println("4. Find_Document_By_Type ");
        System.out.println("5. Find_Document_By_PublishedYear ");
        System.out.println("______________________________________");
        System.out.print("Enter_Your_Choice: ");
        int choice;
        boolean checkLoop = true;
        String documentFind;
        do{
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1 -> {
                    List<Document> list; //= new ArrayList<>();
                    System.out.print("Enter_Document_Title_Need_Find: ");
                    documentFind = cin.nextLine();
                    list = daoImp.findByNameObject(documentFind);
                    System.out.println("________________________________<Document>________________________________");
                    System.out.println("ID        Title                    Author              PublishedYear  Quantity");
                    for(var i : list){
                        System.out.format("%-10s%-25s%-20s%-15d%-10d\n",i.getId(),i.getTitle(),i.getAuthor(),
                                i.getPublishedYear(),i.getQuantity());
                    }
                    System.out.println("______________________________________________________________________________");
                }
                case 2 -> {
                    System.out.print("Enter_DocumentID_Need_Find: ");
                    documentFind = check.checkOutID(cin.nextLine(),"Document");
                    dcm = daoImp.findByIdObject(documentFind);
                    dci.showObject(dcm);
                }
                case 3 -> {
                    System.out.print("Enter_Author_Need_Find: ");
                    documentFind = cin.nextLine();
                    daoImp.findByAuthorObject(documentFind);
                }
                case 4 -> {
                    System.out.print("Enter_Document_Type_Need_Find: ");
                    documentFind = cin.nextLine();
                    daoImp.findByTypeObject(documentFind);
                }
                case 5 -> {
                    System.out.print("Enter_PublishedYear_Need_Find: ");
                    int documentYear = Integer.parseInt(cin.nextLine());
                    daoImp.findByPublishedYearObject(documentYear);
                }
                default -> {
                    System.out.println("End_Find<Document>");
                    checkLoop = false;
                }
            }
            if(checkLoop) System.out.print("Enter_New_Choice: ");
        }while(checkLoop);
    }

    public void actionDocument(){
        DocumentDAOImp daoImp = new DocumentDAOImp();
        System.out.println("_________Document___________");
        System.out.println("1. Show_List_Document");
        System.out.println("2. Append_Document");
        System.out.println("3. Edit_Document");
        System.out.println("4. Remove_Document");
        System.out.println("5. Find_Document");
        System.out.println("____________________________");
        System.out.print("Enter_Your_Choice: ");
        boolean checkLoop = true;
        int choice;
        do {
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1 -> daoImp.showDocument();
                case 2 -> daoImp.appendObject(new DocumentCtrImp().createObject());
                case 3 -> {
                    System.out.print("Enter_DocumentID_Need_Edit: ");
                    daoImp.editObject(cin.nextLine());
                }
                case 4 -> {
                    System.out.print("Enter_DocumentID_Need_Remove: ");
                    daoImp.removeObject(check.checkOutID(cin.nextLine(), "Document"));
                }
                case 5 -> FindDocument(daoImp);
                default -> {
                    System.out.println("End_Action_To_Document");
                    checkLoop = false;
                }
            }
            if(checkLoop) System.out.print("Enter_New_Choice: ");
        }while(checkLoop);
    }
}