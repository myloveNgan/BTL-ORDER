package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Database.JDBC;
import model.tablecode;

public class tableDao {

	private static tableDao instance;
	public static tableDao getInstance() {
		return new tableDao();
	}
	
	public static void setInsrance(tableDao instance) {
		tableDao.instance = instance;
	}
	
	public tableDao() {
	}	
	
	public ArrayList<tablecode> listTable() {
		ArrayList<tablecode> listTable = new ArrayList<tablecode>();
		try {
			Connection connection = JDBC.getConnection(); // để kết nối dữ

			String sql = "select * from tables"; // câu lệnh truy vấn

			PreparedStatement pS = connection.prepareStatement(sql); //

			ResultSet rs = pS.executeQuery(); // lấy dữ liệu trong ps

			while (rs.next()) {
				tablecode table = new tablecode(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4) == 0 ? "Còn trống" : "Đã đặt" );
				listTable.add(table);
			}
			JDBC.closeConection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTable;
	}
}
