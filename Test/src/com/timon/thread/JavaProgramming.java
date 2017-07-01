package com.timon.thread;

public class JavaProgramming {

	public static void main(String[] args) {
		AAAA ref1 = new CCCC();
		BBBB ref2 = (CCCC)ref1;
		ref2.getClass();
	}
}

class AAAA {
	
}

class BBBB extends AAAA {
	
}

class CCCC extends BBBB {
	
}
