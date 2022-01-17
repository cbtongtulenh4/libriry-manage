package DAO;

import Model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonDAOImp implements DAO<Person> {

	String sql;
	Connection conn = new DBConnection().getDBConnection();

	public Person takeObject(String id){
		Person ps = new Person();
		sql = "select * from Person where ID = " + id;
		try{
			//var prepare = conn.prepareCall(sql);
			//prepare.setString(1,id);
			//ResultSet rs = prepare.executeQuery();
			var statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			rs.next();
			ps.setId(id);
			ps.setFullName(rs.getString("FullName"));
			ps.setAddress(rs.getString("Address"));
			ps.setGender(rs.getString("Gender"));
			ps.setDob(rs.getDate("DOB"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ps;
	}

	public void appendObject(Person obj) {
		//throw new UnsupportedOperationException();
		sql = "insert into Person values( ?, ?, ?, ?, ?)";
		try{
			var prepare = conn.prepareCall(sql);
			prepare.setString(1,obj.getId());
			prepare.setString(2,obj.getFullName());
			prepare.setString(3,obj.getAddress());
			prepare.setString(4,obj.getGender());
			prepare.setDate(5, obj.getDob());
			int x = prepare.executeUpdate();
			if(x > 0) System.out.println("Update_Success");
			else System.out.println("Failed_Update");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}


	public void editObject(String id) {
		// TODO - implement PersonDAOImp.editObject
		throw new UnsupportedOperationException();
	}


	public void removeObject(String id) {
		// TODO - implement PersonDAOImp.removeObject
		throw new UnsupportedOperationException();
	}


	public List<Person> findByNameObject(String name) {
		// TODO - implement PersonDAOImp.findByNameObject
		throw new UnsupportedOperationException();
	}


	public Document findByIdObject(String id) {
		// TODO - implement PersonDAOImp.findByIdObject
		throw new UnsupportedOperationException();
	}


	public List<Person> findByTypeObject(String type) {
		// TODO - implement PersonDAOImp.findByTypeObject
		throw new UnsupportedOperationException();
	}

}