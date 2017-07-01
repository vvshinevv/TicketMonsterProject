package com.timon.thread;

public class PriorityTestOne {	
	public static void main(String[] args) {
		MessageSendingThread tr1 = new MessageSendingThread("Fisrt");
		MessageSendingThread tr2 = new MessageSendingThread("Second");
		MessageSendingThread tr3 = new MessageSendingThread("Third");
		
		tr1.start();
		tr2.start();
		tr3.start();
	}
}

class MessageSendingThread extends Thread {
	String message;
	public MessageSendingThread(String str) {
		message = str;
	}
	public void run() {
		for(int i = 0 ; i < 10000; i++)
			System.out.print(message+"(" + getPriority() + ")  ");
	}
}
