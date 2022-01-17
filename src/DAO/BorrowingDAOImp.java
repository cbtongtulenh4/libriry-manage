package DAO;

import Model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BorrowingDAOImp implements DAO<Borrowing> {

	String sql;
	Connection conn = new DBConnection().getDBConnection();

	public void showBorrowing(){
		sql = "select * from Borrowing";
		try{
			var stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			System.out.println("======================Borrow=============================");
			System.out.printf("%-15s%-15s%-15s%-10s\n", "BorrowID", "EmployeeID", "ReaderID", "Total");
			while(rs.next()){
				System.out.printf("%-15s%-15s%-15s%-10s\n",rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4));
				System.out.println("Information's Borrow: ");
				String sql1 = "SELECT dcm.Title, bs.Quantity, bs.Statee From Document AS dcm, BookState AS bs " +
						"WHERE bs.BorrowID = '" + rs.getString(1) + "' " +
						"AND dcm.ID = ( SELECT bk.DocumentID FROM Book AS bk WHERE bk.ID = bs.BookID)";
				var stm1 = conn.createStatement();
				var rs1 = stm1.executeQuery(sql1);
				while(rs1.next()){
					System.out.printf("\t%-15s- %-10s- %-10s\n", rs1.getString(1), rs1.getInt(2),
							rs1.getString(3));
				}
			}
			System.out.println("==========================================================");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void appendObject(Borrowing obj) {
		sql = "insert into Borrowing values(?,?,?,?)";
		try{
			var prepare = conn.prepareCall(sql);
			prepare.setString(1, obj.getBrwId());
			prepare.setString(2, obj.getEmployee().getEmId());
			prepare.setString(3, obj.getReader().getReaderId());
			prepare.setInt(4, obj.getTotal());
			int x = prepare.executeUpdate();
			if(x > 0) {
				new BookStateDAOImp().appendObject(obj);
				System.out.println("Update_Success");
			}
			else System.out.println("Failed_Update");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public Borrowing takeBorrowing(String id){
		sql = "select * from Borrowing where ID = '" + id + "'";
		try{
			var stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()){
				Borrowing br = new Borrowing();
				br.setBrwId(rs.getString(1));
				br.setReader(new ReaderDAOImp().takeObject(rs.getString(3)));
				br.setEmployee(new EmployeeDAOImp().takeObject(rs.getString(2)));
				br.setTotal(rs.getInt(4));
				return br;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}


	public void editObject(String id) {
		// TODO - implement BorrowingDAOImp.editObject
		throw new UnsupportedOperationException();
	}

	public void removeObject(String id) {
		// TODO - implement BorrowingDAOImp.removeObject
		throw new UnsupportedOperationException();
	}

	public List<Borrowing> findByNameObject(String name) {
		// TODO - implement BorrowingDAOImp.findByNameObject
		throw new UnsupportedOperationException();
	}

	public Document findByIdObject(String id) {
		// TODO - implement BorrowingDAOImp.findByIdObject
		throw new UnsupportedOperationException();
	}

	public List<Borrowing> findByTypeObject(String type) {
		// TODO - implement BorrowingDAOImp.findByTypeObject
		throw new UnsupportedOperationException();
	}

	public void sortByNameObject() {

	}

	public void sortByTotalBook() {
		sql = "select br.ReaderID, ps.FullName, sum(br.Total) as Total from Borrowing as br," +
				" Person as ps, Reader as rd\n" +
				"where br.ReaderID = rd.ID and rd.PersonID = ps.ID\n" +
				"group by br.ReaderID, ps.FullName\n" +
				"order by sum(br.Total) desc\n";
		try{
			var stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				System.out.printf("%-15s%-25s%-10s\n", rs.getString(1),
						rs.getString(2), rs.getString(3));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}