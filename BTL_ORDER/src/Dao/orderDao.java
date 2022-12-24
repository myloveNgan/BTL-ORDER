package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Database.JDBC;
import model.orderCode;

public class orderDao {
	private static orderDao instance;

    public orderDao() {
    	
    }

    public static orderDao getInstance() {
        if (instance == null) {
            instance = new orderDao();
        }
        return instance;
    }

    public ArrayList<orderCode> ListOrder(int id) {
    	ArrayList<orderCode> list = new ArrayList<orderCode>();
        Connection con = JDBC.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM orders WHERE invoice_ID = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	orderCode orders = new orderCode(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                list.add(orders);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean Insert(int drinkId, int invoiceId, int count) {
    	Connection con = JDBC.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO orders(drinks_ID, count, invoice_ID) VALUES (?,?,?)");
            pstmt.setInt(1, drinkId);
            pstmt.setInt(2, count);
            pstmt.setInt(3, invoiceId);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return false;
    }
}
