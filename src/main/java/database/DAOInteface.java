package database;

import java.util.ArrayList;

public interface DAOInteface<T> {
	public ArrayList<T> selectALl();
	
	public T selectById(T t);
	
	public int insert(T t);
	
	public int insertAll (ArrayList<T> arr);
	
	public int delete(T t);
	
	public int deleteAll(ArrayList<T> arr);
	
	public int update(T t);
}
