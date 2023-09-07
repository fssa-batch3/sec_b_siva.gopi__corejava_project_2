package in.fssa.agzone.model;

public class User extends UserEntity{
	
	

	public User(int id,String name,long mobileNumber,String district,String town,String password) {
		super.setId(id);
		super.setName(name);
		super.setMobileNumber(mobileNumber);
		super.setDistrict(district);
		super.setTown(town);
		super.setPassword(password);
	}
	
	public User() {
		
	}

}
