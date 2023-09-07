package in.fssa.agzone.model;

public abstract class UserEntity  implements Comparable<User>{

	private int id;
	private String name;
	private long mobileNumber;
	private String district;
	private String town;
	private String password;
	
	private boolean isActive = true;
	
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
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber +",district="+district +",town="+town + ", password=" + password
				+  ", isActive=" + isActive + "]";
	}
	
	public int compareTo(User o) {
		if (this.id == o.getId()) {
			return 0;
		} else if (this.id > o.getId()) {
			return 1;
		} else {
			return -1;
		}
	}
	
	
}
