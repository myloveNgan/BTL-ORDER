package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class drinkCode {
              private String nameDrink;
              private float moneyDrink;
              private Date saleDate ;
              private float sale;
              
              public drinkCode() {
  				
  			}
			public drinkCode(String nameDrink, float moneyDrink, Date saleDate, float sale) {				
				this.nameDrink = nameDrink;
				this.moneyDrink = moneyDrink;
				this.saleDate = saleDate;
				this.sale = sale;
			}
			 public drinkCode(String nameDrink) {
				 this.nameDrink = nameDrink;
	  			}
			public String getNameDrink() {
				return nameDrink;
			}
			public void setNameDrink(String nameDrink) {
				this.nameDrink = nameDrink;
			}
			public float getMoneyDrink() {
				return moneyDrink;
			}
			public void setMoneyDrink(float moneyDrink) {
				this.moneyDrink = moneyDrink;
			}
			public Date getSaleDate() {
				return saleDate;
			}
			public void setSaleDate(Date saleDate) {
				this.saleDate = saleDate;
			}
			public float getSale() {
				return sale;
			}
			public void setSale(float sale) {
				this.sale = sale;
			}
			@Override
			public int hashCode() {
				return Objects.hash(moneyDrink, nameDrink, sale, saleDate);
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				drinkCode other = (drinkCode) obj;
				return Float.floatToIntBits(moneyDrink) == Float.floatToIntBits(other.moneyDrink)
						&& Objects.equals(nameDrink, other.nameDrink)
						&& Float.floatToIntBits(sale) == Float.floatToIntBits(other.sale)
						&& Objects.equals(saleDate, other.saleDate);
			}
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			@Override
			public String toString() {
				return  dateFormat.format(saleDate) ;
			}
              
}
