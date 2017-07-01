package test;

public class Test02 {

	public static void main(String[] args) {
		IPTV iptv = new IPTV();
		iptv.powerOn();
		
		TV[] arrTV = new TV[4];
		arrTV[0] = new TV();
	}
}

class TV {
	public void onTV() {
		System.out.println("영상 출력 중");
	}
	public void aaa() {
		System.out.println("중복");
	}
}

interface Computer {
	public void dataReceive();
	public void aaa();
}

class ComputerImpl {
	public void dataReceive() {
		System.out.println("영상 데이터");
	}
}

class IPTV extends TV implements Computer {
	ComputerImpl computerImpl = new ComputerImpl();
	
	public void powerOn() {
		dataReceive();
		onTV();
		aaa();
		
	}
	public void aaa() {
		System.out.println("중복 띠");
	}
	
	@Override
	public void dataReceive() {
		computerImpl.dataReceive();
	}
	
}