package model;

public class Student {
	private int mssv;
	private String name;
	private String address;

	public int getMssv() {
		return mssv;
	}

	public Student(int mssv, String name, String address) {
		this.mssv = mssv;
		this.name = name;
		this.address = address;
	}

	public Student(int mssv) {
		this.mssv = mssv;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

}
