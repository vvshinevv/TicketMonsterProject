package phonebook.java.lec;

public class PhoneInfo {
	public static void main(String[] args) {
//		PhoneBookVer01 phoneInfo = new PhoneBookVer01("최홍희",  "010-3315-6214");
//		System.out.println(phoneInfo.toString());
		
		AAA comp = new BBB();
		comp.temp();
	}
}

class AAA {
	public AAA() {
		
	}
	void temp() {System.out.println("aaa");}
}

class BBB extends AAA{
	void temp() {System.out.println("bbb");}
}

class PhoneBookVer01 {
	private String name;
	private String phoneNumber;
	private String birthday;
	
	public PhoneBookVer01(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public PhoneBookVer01(String name, String phoneNumber) {
		this(name, phoneNumber, null);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return ("name: " + getName() + "\n" + "phoneNumber: " + getPhoneNumber() + "\n"  + "birthday: " + getBirthday()).toString();
	}
}

