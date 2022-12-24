package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Database.JDBC;
import model.drinkCode;

public class drinkDao {

	public static drinkDao getInstance() {
		return new drinkDao();
	}

	public ArrayList<drinkCode> listDrink() {
		ArrayList<drinkCode> listDrink = new ArrayList<drinkCode>();
		try {
			Connection connection = JDBC.getConnection();

			String sql = "select * from drinks";
			PreparedStatement pS = connection.prepareStatement(sql);

			ResultSet rs = pS.executeQuery();
			while (rs.next()) {
				drinkCode drinks = new drinkCode(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4),
						rs.getDate(5));
				listDrink.add(drinks);
			}
			JDBC.closeConection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDrink;
	}

	public float price(String nameDrink) {
		float ketqua = 0;
		try {
			Connection connection = JDBC.getConnection();

			String sql = "select price from drinks where name = ? ";
			PreparedStatement pS = connection.prepareStatement(sql);
			pS.setString(1, nameDrink);
			ResultSet rs = pS.executeQuery();
			while(rs.next()) {
				ketqua = rs.getFloat("price");
			}
			JDBC.closeConection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	public int drinkID(String nameDrink) {
		int ketqua = 0;
		try {
			Connection connection = JDBC.getConnection();

			String sql = "select id from drinks where name = ? ";
			PreparedStatement pS = connection.prepareStatement(sql);
			pS.setString(1, nameDrink);
			ResultSet rs = pS.executeQuery();
			while(rs.next()) {
				ketqua = rs.getInt("id");
			}
			JDBC.closeConection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua;
	}
}
