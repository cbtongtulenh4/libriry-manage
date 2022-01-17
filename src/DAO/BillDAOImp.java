package DAO;

import Model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BillDAOImp implements DAO<Bill> {

	String sql;
	Connection conn = new DBConnection().getDBConnection();

	public void showBill(){
		sql = "select * from Bill";
		try {
			var stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			System.out.println("==========================Show_Bill=============================");
			while(rs.next()){
				System.out.printf("%-15s%-15s%-20s-%-20s%-15s\n", rs.getString(1),
						rs.getString(2), rs.getDate(3), rs.getDate(4),
						rs.getFloat(5));
			}
			System.out.println("================================================================");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void appendObject(Bill obj) {
		sql = "insert into Bill values(?, ?, ?, ?)";
		try{
			var prepare = conn.prepareCall(sql);
			prepare.setString(1, obj.getBillId());
			prepare.setString(2, obj.getBorrowing().getBrwId());
			prepare.setDate(3, obj.getStartDate());
			prepare.setDate(4, obj.getDueDate());
			prepare.setFloat(5, obj.getDeposit());
			prepare.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void editObject(String id) {
		// TODO - implement BillDAOImp.editObject
		throw new UnsupportedOperationException();
	}

	public void removeObject(String id) {
		// TODO - implement BillDAOImp.removeObject
		throw new UnsupportedOperationException();
	}

	public List<Bill> findByNameObject(String name) {
		// TODO - implement BillDAOImp.findByNameObject
		throw new UnsupportedOperationException();
	}

	public Document findByIdObject(String id) {
		// TODO - implement BillDAOImp.findByIdObject
		throw new UnsupportedOperationException();
	}

	public List<Bill> findByTypeObject(String type) {
		// TODO - implement BillDAOImp.findByTypeObject
		throw new UnsupportedOperationException();
	}

	public List<Book> findBookBorrowMax() {
		// TODO - implement BillDAOImp.findBookBorrowMax
		throw new UnsupportedOperationException();
	}

	public List<Book> findBookBorrowMin() {
		// TODO - implement BillDAOImp.findBookBorrowMin
		throw new UnsupportedOperationException();
	}

	public List<Reader> findReaderBorrowMax() {
		// TODO - implement BillDAOImp.findReaderBorrowMax
		throw new UnsupportedOperationException();
	}

	public List<Reader> findReaderBorrowMin() {
		// TODO - implement BillDAOImp.findReaderBorrowMin
		throw new UnsupportedOperationException();
	}

}