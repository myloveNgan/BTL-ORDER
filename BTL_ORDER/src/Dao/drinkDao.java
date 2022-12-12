package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Database.JDBC;
import model.drinkCode;

public class drinkDao {
	public static drinkDao getInstance() {
		return new drinkDao();
	}

	public int addDrink(drinkCode dC) {
		int ketqua = 0;
		try {
			Connection connection = JDBC.getConnection();

			String sql = "insert into drink(nameDrink,moneyDrink,saleDate,sale) " + "values(?,?,?,?)";

			PreparedStatement pS = connection.prepareStatement(sql);
			pS.setString(1, dC.getNameDrink());
			pS.setFloat(2, dC.getMoneyDrink());
			pS.setDate(3, new java.sql.Date(dC.getSaleDate().getTime()));
			pS.setFloat(4, dC.getSale());
			ketqua = pS.executeUpdate();
			JDBC.closeConection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	public int deleteDrink(drinkCode dC) {
		int ketqua = 0;
		try {
			Connection connection = JDBC.getConnection();
			String sql = "delete from drink where nameDrink = ?";
			
			PreparedStatement pS = connection.prepareStatement(sql);
			pS.setString(1,dC.getNameDrink());
			ketqua = pS.executeUpdate();
			JDBC.closeConection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua ;
	}

	public ArrayList<drinkCode> listDrink() {
		ArrayList<drinkCode> listDrink = new ArrayList<drinkCode>();
		try {
			Connection connection = JDBC.getConnection();

			String sql = "select * from drink";
			PreparedStatement pS = connection.prepareStatement(sql);

			ResultSet rS = pS.executeQuery();
			while (rS.next()) {
				String nameDrink = rS.getNString("nameDrink");
				float moneyDrink = rS.getFloat("moneyDrink");
				java.sql.Date sD = rS.getDate("saleDate");
				Date saleDate = new Date(sD.getTime());
				System.out.println(saleDate);
				float sale = rS.getFloat("sale");
				drinkCode dC = new drinkCode(nameDrink, moneyDrink, saleDate, sale);
				listDrink.add(dC);
			}
			JDBC.closeConection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDrink;
	}
}
