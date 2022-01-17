package DAO;

import Controller.DocumentCtrImp;
import Model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentDAOImp implements DAO<Document> {

	private final Connection conn = new DBConnection().getDBConnection();
	private String sql;
	private Document dcm = new Document();
	private final DocumentCtrImp dci = new DocumentCtrImp();

	public void showDocument(){
		sql = "select * from Document";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("________________________________List<Document>________________________________");
			System.out.println("ID        Title                    Author              PublishedYear  Quantity");
			while(rs.next()){
				System.out.format("%-10s%-25s%-20s%-15s%-10s",rs.getString(1),rs.getString(2),
						rs.getString(3), rs.getString(4),rs.getString(5));
				System.out.println();
			}
			System.out.println("______________________________________________________________________________");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Document takeDocument(String id){
		sql = "select * from Document where ID = '" + id + "'";
		try{
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()){
				Document dcm = new Document();
				dcm.setId(id);
				dcm.setQuantity(rs.getInt("Quantity"));
				dcm.setPublishedYear(rs.getInt("PublishedYear"));
				dcm.setTitle(rs.getString("Title"));
				dcm.setAuthor(rs.getString("Author"));
				return dcm;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void appendObject(Document obj) {
		sql = "insert into Document values(?,?,?,?,?)";
		try {
			var prepare = conn.prepareCall(sql);
			prepare.setString(1,obj.getId());
			prepare.setString(2,obj.getTitle());
			prepare.setString(3,obj.getAuthor());
			prepare.setInt(4,obj.getPublishedYear());
			prepare.setInt(5,obj.getQuantity());
			prepare.executeUpdate();
		//	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void editObject(String id) {
		//throw new UnsupportedOperationException();
		dcm = findByIdObject(id);
		System.out.println("Document_Need_Edit");
		int choice;
		do{
			dci.showObject(dcm);
			System.out.print("Enter_Column_Need_Edit: ");
			String col = new Scanner(System.in).nextLine();
			System.out.print("Enter_New_Value's_Column:");
			String newValue = new Scanner(System.in).nextLine();
			if(col.equals("ID")){
				boolean checkID = true;
				do{
					String regex = "^[a-zA-z]{2}_\\d{3}$";
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(newValue);
					if(matcher.find() && new Check().checkInID(newValue,"Document"))
						checkID = false;
					else {
						System.out.print("You_Can_Try_Again: ");
						newValue = new Scanner(System.in).nextLine();
					}
				}while(checkID);
			}
			/*switch(col){
				case "ID":
					boolean checkID = true;
					do{
						newValue = new Scanner(System.in).nextLine();
						String regex = "^[a-zA-z]{2}_\\d{3}$";
						Pattern pattern = Pattern.compile(regex);
						Matcher matcher = pattern.matcher(newValue);
						if(matcher.find() && new Check().checkInID(newValue,"Document"))
							checkID = false;
						else System.out.print("You_Can_Try_Again: ");
					}while(checkID);
					break;
				case "Title", "Author":
					newValue = new Scanner(System.in).nextLine();
					break;
				case "PublishedYear", "Quantity":
					int newValue = new Scanner(System.in).nextInt();
					break;
			}*/
			sql = "update Document set " + col + " = ? where ID = ?";
			try {
				var prepare = conn.prepareCall(sql);
				//prepare.setString(1,col);
				prepare.setString(1,newValue);
				prepare.setString(2,id);
				int x = prepare.executeUpdate();
				if(x > 0) {
					System.out.println("Success_Update");
					if(col.equals("ID")) id = newValue;
				}
				else System.out.println("Failed_Update");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Do_You_Wanna_Continue_Editing ?");
			System.out.println("\t1. Yes   ||   2. No");
			System.out.print("Your_Choice: ");
			choice = new Scanner(System.in).nextInt();
		}while(choice == 1);

	}


	public void removeObject(String id) {
		//throw new UnsupportedOperationException();
		sql = "delete from Document where ID = '" + id + "'";
		try{
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Removed_This_Document");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}


	public List<Document> findByNameObject(String name) {
		//throw new UnsupportedOperationException();
		sql = "select * from Document where Title = ?";
		List<Document> list = new ArrayList<>();
		try {
			var prepare = conn.prepareCall(sql);
			prepare.setString(1,name);
			ResultSet rs = prepare.executeQuery();
			while(rs.next()){
				Document dcm = new Document();
				dcm.setId(rs.getString("ID"));
				dcm.setTitle(rs.getString("Title"));
				dcm.setAuthor(rs.getString("Author"));
				dcm.setPublishedYear(rs.getInt("PublishedYear"));
				dcm.setQuantity(rs.getInt("Quantity"));
				list.add(dcm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public Document findByIdObject(String id) {
		//throw new UnsupportedOperationException();
		sql = "select * from Document where ID = ?";
		try {
			var prepare = conn.prepareCall(sql);
			prepare.setString(1,id);
			ResultSet rs = prepare.executeQuery();
			rs.next();
				dcm.setId(rs.getString(1));
				dcm.setTitle(rs.getString(2));
				dcm.setAuthor(rs.getString(3));
				dcm.setPublishedYear(rs.getInt(4));
				dcm.setQuantity(rs.getInt(5));
			//	dcm = rs.getObject(1,Class<Document> Document);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dcm;
	}

	@Override
	public List<Document> findByTypeObject(String type) {
		return null;
	}

	public List<Document> findByAuthorObject(String author) {
		//throw new UnsupportedOperationException();
		sql = "select * from Document where Author = ?";
		List<Document> list = new ArrayList<>();
		try {
			var prepare = conn.prepareCall(sql);
			prepare.setString(1,author);
			ResultSet rs = prepare.executeQuery();
			while(rs.next()){
				Document dcm = new Document();
				dcm.setId(rs.getString("ID"));
				dcm.setTitle(rs.getString("Title"));
				dcm.setAuthor(rs.getString("Author"));
				dcm.setPublishedYear(rs.getInt("PublishedYear"));
				dcm.setQuantity(rs.getInt("Quantity"));
				list.add(dcm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public List<Document> findByPublishedYearObject(int publishedYear) {
		//throw new UnsupportedOperationException();
		sql = "select * from Document where PublishedYear = ?";
		List<Document> list = new ArrayList<>();
		try {
			var prepare = conn.prepareCall(sql);
			prepare.setInt(1,publishedYear);
			ResultSet rs = prepare.executeQuery();
			while(rs.next()){
				Document dcm = new Document();
				dcm.setId(rs.getString("ID"));
				dcm.setTitle(rs.getString("Title"));
				dcm.setAuthor(rs.getString("Author"));
				dcm.setPublishedYear(rs.getInt("PublishedYear"));
				dcm.setQuantity(rs.getInt("Quantity"));
				list.add(dcm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}