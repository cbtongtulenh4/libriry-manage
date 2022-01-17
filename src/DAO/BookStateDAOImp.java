package DAO;

import Model.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookStateDAOImp {

	private String sql;
	private final Connection conn = new DBConnection().getDBConnection();

	public void appendObject(Borrowing br) {
		sql = "insert into BookState values(?, ?, ?, ?)";
		try{
			var prepare = conn.prepareCall(sql);
			for(var i : br.getStates()){
				prepare.setString(1,br.getBrwId());
				prepare.setString(2, i.getBookId());
				prepare.setInt(3, i.getQuantity());
				prepare.setString(4, i.getState());
				prepare.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void editObject(String id) {
		// TODO - implement BookStateDAOImp.editObject
		throw new UnsupportedOperationException();
	}

	public void removeObject(String id) {
		// TODO - implement BookStateDAOImp.removeObject
		throw new UnsupportedOperationException();
	}

	public List<Document> findByNameObject(String name) {
		// TODO - implement BookStateDAOImp.findByNameObject
		throw new UnsupportedOperationException();
	}

	public BookState findByIdObject(String id) {
		// TODO - implement BookStateDAOImp.findByIdObject
		throw new UnsupportedOperationException();
	}

//	public List<BookState> findByTypeObject(String type) {
//		// TODO - implement BookStateDAOImp.findByTypeObject
//		throw new UnsupportedOperationException();
//	}
//

	public List<BookState> findByStateObject(String state) {
		// TODO - implement BookStateDAOImp.findByStateObject
		throw new UnsupportedOperationException();
	}
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