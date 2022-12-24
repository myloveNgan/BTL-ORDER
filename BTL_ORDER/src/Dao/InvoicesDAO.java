package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Database.JDBC;

public class InvoicesDAO {
	private static InvoicesDAO instance;

    public InvoicesDAO() {
    }

    public static InvoicesDAO getInstance() {
        if (instance == null) {
            instance = new InvoicesDAO();
        }
        return instance;
    }

    public int GetUncheckInvoiceByTableId(int id) {
        Connection con = JDBC.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM invoice WHERE tables_id = ? AND status = 0");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return -1;
    }

    public Boolean Insert(int id, int accountId) {
    	 Connection con = JDBC.getConnection();
        try {
            Statement stmt = con.createStatement();
            int i = stmt.executeUpdate("INSERT INTO invoice(account_ID, tables_id, status) VALUES ('" + accountId + "','" + id + "',0)");
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int GetMaxIdInvoice() {
    	 Connection con = JDBC.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT MAX(ID) FROM invoice");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }

    public void Update(int id, int totalPrice) {
    	 Connection con = JDBC.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE invoice SET status= 1, total_price = ? WHERE ID = ?");
            pstmt.setInt(1, totalPrice);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
        	  e.printStackTrace();
        }
    }
}
