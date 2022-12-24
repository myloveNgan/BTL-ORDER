package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Database.JDBC;
import model.menuCode;

public class menuDao {
	 private static menuDao instance;

	    public menuDao() {
	    }

	    public static menuDao getInstance() {
	        if (instance == null) {
	            instance = new menuDao();
	        }
	        return instance;
	    }

	    public static void setInstance(menuDao instance) {
	    	menuDao.instance = instance;
	    }

	    public ArrayList<menuCode> GetListMenuByTableId(int id) {
	        ArrayList<menuCode> list = new ArrayList<menuCode>();
	        Connection con = JDBC.getConnection();
	        try {
	            PreparedStatement pstmt = con.prepareStatement("SELECT drinks.name, orders.count, drinks.price, orders.count*drinks.price AS totalPrice "
	            		+ "FROM orders, invoice, drinks "
	            		+ "WHERE orders.invoice_ID = invoice.ID AND orders.drinks_ID = drinks.ID AND invoice.status = 0 AND invoice.tables_id = ?");
	            pstmt.setInt(1, id);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	menuCode menu = new menuCode(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
	                list.add(menu);
	            }
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	        return list;
}
}
