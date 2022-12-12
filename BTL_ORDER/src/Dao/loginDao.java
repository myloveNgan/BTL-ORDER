package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Database.JDBC;
import model.login;

public class loginDao implements daoInterface<login> {
	public static loginDao getInstance() {
		return new loginDao();
	}

	@Override
	public int addRegiter(login t) {
		int ketqua = 0;
		try {
			Connection connection = JDBC.getConnection();
			String sql = "insert into login (useName , passWd , hoVaTen)" + " values(?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getNameuser());
			ps.setString(2, t.getPass());
			ps.setNString(3, t.getName());
			ketqua = ps.executeUpdate();

			JDBC.closeConection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int update(login t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(login t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<login> selectALL() {
		ArrayList<login> listLogin = new ArrayList<login>();
		try {
			Connection connection = JDBC.getConnection();
			String sql = "select * from login";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String useName = rs.getString("useName");
				String passWd = rs.getString("passWd");
				String hoVaTen = rs.getNString("hoVaTen");
				login lg = new login(useName, passWd, hoVaTen);
				listLogin.add(lg);
			}
			JDBC.closeConection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listLogin;
	}

	@Override
	public String selectById(login t) {
		String s = null;
		try {
			Connection connection = JDBC.getConnection();
			
			String sql = "select hoVaTen "+
			            "from login " +
					    "where useName = ? and passWd = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,t.getNameuser());
			ps.setString(2, t.getPass());
			
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s = rs.getNString("hoVaTen");
			}
			JDBC.closeConection(connection);
		} catch (Exception e) {
			e.printStackTrace();		
			}
		return s ;
	}

	@Override
	public ArrayList<login> selectByCondition(String condition) {
		return null;
	}

}
