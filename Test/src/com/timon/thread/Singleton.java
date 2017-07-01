package com.timon.thread;

public class Singleton {
	public static void main(String[] args) {
		
	}
}

class Singleton1 {
	private static Singleton1 singletonInstance1;
	public static synchronized Singleton1 getInstance() {
		if(singletonInstance1 == null) 
			singletonInstance1 = new Singleton1();
		
		return singletonInstance1;
	}
}

class Singleton2 {
	private static Singleton2 singletonInstance2;
	public static Singleton2 getInstance() {
		if(singletonInstance2 == null) {
			synchronized (Singleton2.class) {
				if(singletonInstance2 == null) {
					singletonInstance2 = new Singleton2();
				}
			}
		}
		return singletonInstance2;
	}
}
