package DAO;

import Model.*;

import java.util.List;

public interface DAO<T> {

	void appendObject(T obj);

	void editObject(String id);

	void removeObject(String id);

	List<T> findByNameObject(String name);

	Document findByIdObject(String id);

	List<T> findByTypeObject(String type);

}