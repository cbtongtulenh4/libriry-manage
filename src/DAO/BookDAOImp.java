package DAO;

import Model.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDAOImp extends DocumentDAOImp {

	private String sql;
	private final Connection conn = new DBConnection().getDBConnection();


	public void appendObject(Book obj) {
		sql = "insert into Book values(?, ?, ?)";
		try{
			CallableStatement prepare = conn.prepareCall(sql);
			prepare.setString(1,obj.getBookId());
			prepare.setString(2,obj.getId());
			prepare.setString(3, obj.getType());
			int x = prepare.executeUpdate();
			if(x > 0) System.out.println("Success_Update");
			else System.out.println("Failed_Update");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public Book takeBook(String id){
		sql = "select * from Book where ID = '" + id + "'";
		try{
			var stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				Book book = new Book();
				book.setBookId(id);
				book.setDocument(new DocumentDAOImp().takeDocument(rs.getString("DocumentID")));
				book.setType(rs.getString(3));
				return book;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	public void editObject(String id) {
		// TODO - implement BookDAOImp.editObject
		throw new UnsupportedOperationException();
	}

	public void removeObject(String id) {
		// TODO - implement BookDAOImp.removeObject
		throw new UnsupportedOperationException();
	}


	public List<Document> findByNameObject(String name) {
		// TODO - implement BookDAOImp.findByNameObject
		throw new UnsupportedOperationException();
	}

	public Book findByIdObject(String id) {
		// TODO - implement BookDAOImp.findByIdObject
		throw new UnsupportedOperationException();
	}
//
//	public List<Book> findByTypeObject(String type) {
//		// TODO - implement BookDAOImp.findByTypeObject
//		throw new UnsupportedOperationException();
//	}
//
//
//	public List<Book> findByAuthorObject(String author) {
//		// TODO - implement BookDAOImp.findByAuthorObject
//		throw new UnsupportedOperationException();
//	}
//
//	public List<Book> findByPublishedYearObject(int publishedYear) {
//		// TODO - implement BookDAOImp.findByPublishedYearObject
//		throw new UnsupportedOperationException();
//	}

}