package Dao;

import java.util.ArrayList;

import model.login;

public interface daoInterface<T> {
          
	public int addRegiter(T t) ;
	public int update(T t);
	public int delete(T t);
    public ArrayList<T> selectALL();
    public String selectById(T t);
    public ArrayList<T> selectByCondition(String condition);	
}
