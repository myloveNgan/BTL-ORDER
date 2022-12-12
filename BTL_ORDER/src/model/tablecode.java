package model;

import java.util.Objects;

public class tablecode {
	private int numberTable;
	private String status;
	private String note;

	public tablecode(int numberTable, String status, String note) {

		this.numberTable = numberTable;
		this.status = status;
		this.note = note;
	}

	public tablecode(int numberTable) {
		super();
		this.numberTable = numberTable;
	}
	
	

	public tablecode(int numberTable, String note) {
		
		this.numberTable = numberTable;
		this.note = note;
	}

	public tablecode() {

	}

	public int getnumberTable() {
		return numberTable;
	}

	public void setnumberTable(int nameTable) {
		this.numberTable = nameTable;
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

	@Override
	public String toString() {
		return "tablecode [nameTable=" + numberTable + ", status=" + status + ", note=" + note + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numberTable, note, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		tablecode other = (tablecode) obj;
		return numberTable == other.numberTable && Objects.equals(note, other.note) && status == other.status;
	}

}
