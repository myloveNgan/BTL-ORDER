package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Database.JDBC;
import model.tablecode;

public class tableDao {

	public static tableDao getInstance() {
		return new tableDao();
	}

	public int addTable(tablecode tC) {
		int table = 0;
		try {
			Connection connection = JDBC.getConnection();

			String sql = "insert into dinnerTable(numberTable,note,statusTable) " + "values(?,?,?)";

			PreparedStatement pS = connection.prepareStatement(sql);

			pS.setInt(1, tC.getnumberTable());
			pS.setString(2, tC.getNote());
			pS.setString(3, "Còn trống");

			table = pS.executeUpdate();
			JDBC.closeConection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return table;
	}

	public int deleteTable(tablecode tc) {
		int ketqua = 0;
		try {
			Connection connection = JDBC.getConnection();

			String sql = "delete  from dinnerTable " + "where numberTable = ?";
			PreparedStatement pS = connection.prepareStatement(sql);
			pS.setInt(1, tc.getnumberTable());

			ketqua = pS.executeUpdate();
			JDBC.closeConection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua;
	}
    
	public int update(tablecode tc , tablecode id) {
		int ketqua = 0 ;
		try {
			Connection connection = JDBC.getConnection();
			
			String sql = " update dinnerTable "+
			             " set numberTable = ? , note =  ?, statusTable = ? "+
					     " where numberTable = ?";
			
			PreparedStatement pS = connection.prepareStatement(sql);
			
			pS.setInt(1, tc.getnumberTable());
			pS.setString(2, tc.getNote());
			pS.setString(3, tc.getStatus());
			pS.setInt(4,id.getnumberTable());
			
			ketqua = pS.executeUpdate();
			JDBC.closeConection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	public ArrayList<tablecode> listTable() {
		ArrayList<tablecode> listTable = new ArrayList<tablecode>();
		try {
			Connection connection = JDBC.getConnection(); // để kết nối dữ

			String sql = "select * from dinnerTable"; // câu lệnh truy vấn

			PreparedStatement pS = connection.prepareStatement(sql); //

			ResultSet rs = pS.executeQuery(); // lấy dữ liệu trong ps

			while (rs.next()) {
				int numberTable = rs.getInt("numberTable");
				String note = rs.getNString("note");
				String status = rs.getNString("statusTable");

				tablecode tc = new tablecode(numberTable, status, note);

				listTable.add(tc);
			}
			JDBC.closeConection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTable;
	}
}
