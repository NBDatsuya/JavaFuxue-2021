public class Teacher extends Person{
    
	private String phoneNumber;

	public Teacher(int id,String name, String phoneNumber) {
		super(id,name);
		this.phoneNumber = phoneNumber;
	}
    public String getPhoneNumber() {
    	return phoneNumber;
    }
	
}
