package DAO;

import Model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReaderDAOImp extends PersonDAOImp {

	private final Connection conn = new DBConnection().getDBConnection();
	private String sql;
	//private Reader rd = new Reader();
//	private ReaderCtrImp rci = new ReaderCtrImp();

	public void showReader(){
		sql = "select * from Reader";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("________________________________List<Reader>___________________________________");
			System.out.println("Reader_ID   Person_ID   Kind_OF_Reader  Email                    Phone_Number");
			while(rs.next()){
				System.out.format("%-12s%-12s%-16s%-25s%-15s\n",rs.getString("ID"),rs.getString("PersonID"),
						rs.getString(5), rs.getString("Email"),rs.getString("Phone"));
				System.out.println();
			}
			System.out.println("_______________________________________________________________________________");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Reader takeObject(String id){
		Reader rd = new Reader();
		sql = "select * from Reader where ID = '" + id + "'";
		try{
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			rd.setReaderId(id);
			rd.setPerson(new PersonDAOImp().takeObject(rs.getString("PersonID")));
			rd.setKindOfReader(rs.getString(5));
			rd.setEmail(rs.getString("Email"));
			rd.setPhoneNumber(rs.getString("Phone"));
		}catch (SQLException e){
			e.printStackTrace();
		}
		return rd;
	}

	public void appendObject(Reader obj) {
		//throw new UnsupportedOperationException();
		sql = "insert into Reader values(?, ?, ?, ?, ?)";
		try{
			var prepare = conn.prepareCall(sql);
			prepare.setString(1,obj.getReaderId());
			prepare.setString(2,obj.getId());
			prepare.setString(3,obj.getEmail());
			prepare.setString(4,obj.getPhoneNumber());
			prepare.setString(5,obj.getKindOfReader());
			int x = prepare.executeUpdate();
			if(x > 0) System.out.println("Update_Success");
			else System.out.println("Update_Failed");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void editObject(String id) {
		// TODO - implement ReaderDAOImp.editObject
		throw new UnsupportedOperationException();
	}

	public void removeObject(String id) {
		sql = "delete from Reader where ID = '" + id + "'";
		try{
			Statement stmt = conn.createStatement();
			int x = stmt.executeUpdate(sql);
			if(x > 0) System.out.println("Success_Delete");
			else System.out.println("Failed_Delete");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public List<Reader> FindByNameObject(String name) {
		//throw new UnsupportedOperationException();
		List<Reader> list = new ArrayList<>();
		sql = "select * from Reader where PersonID = " +
				"( select ID from Person where FullName = ? )";
		try{
			var prepare = conn.prepareCall(sql);
			prepare.setString(1, name);
			ResultSet rs = prepare.executeQuery();
			while(rs.next()){
				Reader rd = new Reader();
				rd.setReaderId(rs.getString("ID"));
				rd.setId(rs.getString("PersonID"));
				rd.setEmail(rs.getString("Email"));
				rd.setPhoneNumber(rs.getString("PhoneNumber"));
				rd.setKindOfReader(rs.getString(5));
				list.add(rd);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}


//	public List<Reader> findByTypeObject(String type) {
//		// TODO - implement ReaderDAOImp.findByTypeObject
//		throw new UnsupportedOperationException();
//	}
	
//	public Reader findByIdObject(String id) {
//		// TODO - implement ReaderDAOImp.findByIdObject
//		throw new UnsupportedOperationException();
//	}

}