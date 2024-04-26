//Anas Al Sayed **1221020**
package application;

import java.util.Date;

public class Martyr {
	// Name, location, and Gender of the martyr...


	private String Name,Gender;
	Location location;
	District district;
	// Age of the martyr...

	private int age;

	// Date of death of the martyr...

	private java.util.Date DateOfDeath;

	//Constructs a Martyr object with the specified attributes...

	public Martyr(String name, Date dateOfDeath,int age,Location location,District district  ,String gender) {
		super();
		Name = name;
		this.age = age;
		this.location = location;
		this.district=district;
		DateOfDeath = dateOfDeath;
		Gender = gender;
	}

	// Getter and setter methods for the attributes of the Martyr object...
	//O(1).
	public int getAge() {
		return age;
	}
	//O(1).
	public void setAge(int age) {
		this.age = age;
	}
	//O(1).
	public String getName() {
		return Name;
	}
	//O(1).
	public void setName(String name) {
		Name = name;
	}
	//O(1).
	public Location getLocation() {
		return location;
	}
	//O(1).
	public District getDistrict() {
		return district;
	}
	//O(1).
	public void setDistrict(District district) {
		this.district = district;
	}
	//O(1).
	public void setLocation(Location location) {
		this.location = location;
	}
	//O(1).
	public java.util.Date getDateOfDeath() {
		return DateOfDeath;
	}
	//O(1).
	public void setDateOfDeath(java.util.Date dateOfDeath) {
		DateOfDeath = dateOfDeath;
	}
	//O(1).
	public String getGender() {
		return Gender;
	}
	//O(1).
	public void setGender(String gender) {
		Gender = gender;
	}
	
	//Name,Date,Age,location,District,Gender
	//O(1).
	@Override
	public String toString() {
		return Name + ","+   DateOfDeath.getMonth()+"/"+DateOfDeath.getDay()+"/"+(DateOfDeath.getYear()+1900)+","+age+"," + ","+ location.getLname() + ","+ district.getDname()
				+","+Gender;
	}
	
}
