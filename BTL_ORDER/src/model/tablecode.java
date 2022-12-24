package model;

public class tablecode {
	private int tableId;
	private String numberTable;
	private String status;
	private String note;

	public tablecode(int tableId, String numberTable, String status, String note) {
		this.tableId = tableId;
		this.numberTable = numberTable;
		this.status = status;
		this.note = note;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public String getNumberTable() {
		return numberTable;
	}

	public void setNumberTable(String numberTable) {
		this.numberTable = numberTable;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
