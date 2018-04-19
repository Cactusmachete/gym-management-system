package application;

public class Staff extends Person{
	/*
	 *  Class used for staff. 
	 *  type = 0/1/2 where (0=other, 1=trainer, 2=admin)
	 */
	private int id;
	private int type;
	private boolean adminAccess=false;

	public Staff(String name, String email, int number, String address, int id, int type) {
		super(name, email, number, address);
		this.id = id;
		this.type = type;
	}
	
	public void setAdmin() {
		this.adminAccess = true;
	}
	
	public int getID() {
		return this.id;
	}
	
	public int getType() {
		return this.type;
	}
	
	public boolean adminAccess() {
		return this.adminAccess;
	}
	


}
