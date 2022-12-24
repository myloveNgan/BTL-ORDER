package model;

public class orderCode {
	private int id;
	private int drinksId;
	private int invoiceId;
	private int count;

	public orderCode(int id, int drinksId, int invoiceId, int count) {
		this.id = id;
		this.drinksId = drinksId;
		this.invoiceId = invoiceId;
		this.count = count;
	}

	public orderCode() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDrinksId() {
		return drinksId;
	}

	public void setDrinksId(int drinksId) {
		this.drinksId = drinksId;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
