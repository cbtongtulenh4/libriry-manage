package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Check {

    public boolean checkID(String ID, String tableName){
        Connection conn = new DBConnection().getDBConnection();
        var sql = "SELECT ID FROM " + tableName + " WHERE ID = ?";
        try {
            var prepare = conn.prepareStatement(sql);
            prepare.setString(1,ID);
            ResultSet rs = prepare.executeQuery();
            if(rs.next()) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean checkInID(String ID, String tableName){
        if(!checkID(ID,tableName)) {
            System.out.println("ID_Already_Exists");
            return false;
        }
        return true;
    }

    public String checkOutID(String ID, String tableName){
        while(checkID(ID, tableName)){
            System.out.println("ID_Dose_Not_Exists");
            System.out.print("You_Can_Try_Again: ");
            ID = new Scanner(System.in).nextLine();
        }
        return ID;
    }

}
