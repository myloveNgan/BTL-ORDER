package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Database.JDBC;
import model.login;

public class loginDao {

	 private static loginDao instance;
	    login account = new login();

	    public loginDao() {
	    }

	    public static loginDao getInstance() {
	        if (instance == null) {
	            instance = new loginDao();
	        }
	        return instance;
	    }

	    public static void setInstance(loginDao instance) {
	    	loginDao.instance = instance;
	    }

	    public Boolean Login(String username, String password) {
	        Connection con = JDBC.getConnection();
	        try {
	            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM account WHERE usename = ? AND password = ?");
	            pstmt.setString(1, username);
	            pstmt.setString(2, password);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                account.setId(rs.getInt(1));
	                account.setNameuser(rs.getString(2));
	                account.setPass(rs.getString(3));
	                account.setName(rs.getString(4));
	                return true;
	            }
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	        return false;
	    }

	    public login GetAccount() {
	        return account;
	    }

	    public List<login> listAccount() {
	        List<login> list = new ArrayList<login>();
	        Connection con = JDBC.getConnection();
	        try {
	            PreparedStatement pstmt = con.prepareStatement("SELECT ID, usename, password, name FROM account");
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	            	login account = new login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
	                list.add(account);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	    public Boolean Add(String name, String username, String pass) {
	        Connection con = JDBC.getConnection();
	        try {
	            PreparedStatement pstmt = con.prepareStatement("INSERT INTO account(usename, password, name) VALUES (?,?,?)");
	            pstmt.setString(1, username);
	            pstmt.setString(2, pass);
	            pstmt.setString(3, name);
	            int i = pstmt.executeUpdate();
	            if (i > 0) {
	                return true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public Boolean Update(int id, String name, String pass) {
	        Connection con = JDBC.getConnection();
	        try {
	            PreparedStatement pstmt = con.prepareStatement("UPDATE account SET password=?,name=? WHERE ID=?");
	            pstmt.setString(1, pass);
	            pstmt.setString(2, name);
	            pstmt.setInt(3, id);
	            int i = pstmt.executeUpdate();
	            if (i > 0) {
	                return true;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public Boolean Delete(int id) {
	    	Connection con = JDBC.getConnection();
	        try {
	            PreparedStatement pstmt = con.prepareStatement("Delete from account where ID=?");
	            pstmt.setInt(1, id);
	            int i = pstmt.executeUpdate();
	            if (i > 0) {
	                return true;
	            }
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	        return false;
	    }

	    public Boolean DoiMatKhau(int id, String pass) {
	    	Connection con = JDBC.getConnection();
	        try {
	            PreparedStatement pstmt = con.prepareStatement("UPDATE account SET password=? WHERE ID=?");
	            pstmt.setString(1, pass);
	            pstmt.setInt(2, id);
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
