package test;

public class Test01 {

	public static void main(String[] args) {
		BusinessMan businessMan = new BusinessMan("최홍희", "LG전자", "개발자");
		businessMan.tellYourName();
		businessMan.tellYourInfo();
	}
}

class Man {
	String fname;
	//String  lname;
	//public Man(String fname) { this.fname = fname; 
	//this.lname = null; 
	//}
	//public Man(String fname, String lname) { this.fname = fname; this.lname = lname; }
	public void tellYourName() { System.out.println("My name is " + fname); }
}

class BusinessMan extends Man {
	private String  company;
	private String position;
	
	public BusinessMan(String name, String company, String position) {
		
		//super(name);
		this.company = company;
		this.position = position;
	}
	
	public void tellYourInfo() {
		System.out.println("My company is " + company);
		System.out.println("My position is " + position);
		tellYourName();
	}
}


