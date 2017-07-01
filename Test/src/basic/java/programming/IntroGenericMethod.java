package basic.java.programming;

class AAA {
	public String toString() {
		return "Class AAA";
	}
}

class BBB {
	public String toString() {
		return "Class BBB";
	}
}

class InstanceTypeShower {
	int showCnt = 0;
	public<T> void showInstType(T inst) {
		System.out.println(inst);
		showCnt++;
	}
	
	void showPrintCnt() {
		System.out.println("Show count: " + showCnt);
	}
}

public class IntroGenericMethod {

	public static void main(String[] args) {
		AAA aaa = new AAA();
		BBB bbb = new BBB();
		
		InstanceTypeShower instanceTypeShower = new InstanceTypeShower();
		instanceTypeShower.showInstType("hong");
		instanceTypeShower.<BBB>showInstType(bbb);
		instanceTypeShower.showPrintCnt();
	}
}
