package DAO;

import Model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class EmployeeDAOImp extends PersonDAOImp {

	private final Connection conn = new DBConnection().getDBConnection();
	private String sql;

	public void showEmployee(){
		sql = "select * from Employee";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("________________________________List<Employee>___________________________________");
			System.out.format("%-15s%-12s%-15s%-15s\n", "Employee_ID", "Person_ID", "Role", "Shift");
			while(rs.next()){
				System.out.format("%-15s%-12s%-15s%-15s\n",rs.getString("ID"),rs.getString("PersonID"),
						rs.getString(3), rs.getString(4));
			}
			System.out.println("_______________________________________________________________________________");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Employee takeObject(String id){
		Employee rd = new Employee();
		sql = "select * from Employee where ID = '" + id + "'";
		try{
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			rd.setEmId(id);
			rd.setPerson(new PersonDAOImp().takeObject(rs.getString("PersonID")));
			rd.setRole(rs.getString(3));
			rd.setShift(rs.getString(4));
		}catch (SQLException e){
			e.printStackTrace();
		}
		return rd;
	}

	public void appendObject(Employee obj) {
		sql = "insert into Employee values(?, ?, ?, ?)";
		try{
			var prepare = conn.prepareCall(sql);
			prepare.setString(1,obj.getEmId());
			prepare.setString(2,obj.getId());
			prepare.setString(3,obj.getRole());
			prepare.setString(4,obj.getShift());
			int x = prepare.executeUpdate();
			if(x > 0) System.out.println("Update_Success");
			else System.out.println("Update_Failed");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}


	public void editObject(String id) {
		// TODO - implement EmployeeDAOImp.editObject
		throw new UnsupportedOperationException();
	}

	public void removeObject(String id) {
		// TODO - implement EmployeeDAOImp.removeObject
		throw new UnsupportedOperationException();
	}

//	public List<Employee> findByNameObject(String name) {
//		// TODO - implement EmployeeDAOImp.findByNameObject
//		throw new UnsupportedOperationException();
//	}


//	public List<Employee> findByTypeObject(String role) {
//		// TODO - implement EmployeeDAOImp.findByTypeObject
//		throw new UnsupportedOperationException();
//	}


	public List<Employee> findByShiftObject(String shift) {
		// TODO - implement EmployeeDAOImp.findByShiftObject
		throw new UnsupportedOperationException();
	}

//	public Employee findByIdObject(String id) {
//		// TODO - implement EmployeeDAOImp.findByIdObject
//		throw new UnsupportedOperationException();
//	}

}