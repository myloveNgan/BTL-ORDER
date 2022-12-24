package model;

import java.util.Date;


public class drinkCode {
	          private int id;
              private String name;
              private float price;
              private Date startDate ;
              private Date endDate ;
              
			public drinkCode() {
				
			}

			public drinkCode(int id, String name) {
				this.id = id;
				this.name = name;
			}

			public drinkCode(int id, String name, float price, Date startDate, Date endDate) {				
				this.id = id;
				this.name = name;
				this.price = price;
				this.startDate = startDate;
				this.endDate = endDate;
			}

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public float getPrice() {
				return price;
			}

			public void setPrice(float price) {
				this.price = price;
			}

			public Date getStartDate() {
				return startDate;
			}

			public void setStartDate(Date startDate) {
				this.startDate = startDate;
			}

			public Date getEndDate() {
				return endDate;
			}

			public void setEndDate(Date endDate) {
				this.endDate = endDate;
			}

			@Override
			public String toString() {
				return name ;
			}
         
}
