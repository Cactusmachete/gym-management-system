package application;

abstract class Person {
	/*
	 * Abstract person class inherited by Users and Staff.
	 */
	private String firstName="", lastName="", middleName="", email="", address="";
	private int phoneNumber;
	
	public Person(String name, String email, int number, String address) {
		String[] a = name.split("\\s+");
		this.firstName = a[0];
		if(a.length>1) {
			this.lastName = a[a.length -1];
			if(a.length>2) {
				a[0] = "";
				a[a.length -1]="";
				this.middleName = String.join(" ", a);
			}
		}
		this.email = email;
		this.phoneNumber = number;	
		this.address = address;
	}
	
	public String getName() {
		return String.join(" ", this.firstName, this.middleName, this.lastName);
	}
	
	public String getFName() {
		return this.firstName;
	}
	
	public String getLName() {
		return this.lastName;
	}
	
	public String getMName() {
		return this.middleName;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public int getPhoneNum() {
		return this.phoneNumber;
	}
	
	public String getEmail() {
		return this.email;
	}
}
