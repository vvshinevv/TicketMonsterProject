package com.timon.thread;

import java.util.Scanner;

public class Solve23_2 {
	public static void main(String[] args) {
		IntegerComm integerComm = new IntegerComm();
		CalculateThread c1 = new CalculateThread(integerComm);
		c1.start();
		
		Scanner input = new Scanner(System.in);
		for(int i = 0 ; i < 5; i++)
			integerComm.setSum(input.nextInt());
		
		try {
			c1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		input.close();
	}
}
class CalculateThread extends Thread {
	IntegerComm integerComm;
	private int sum = 0;
	public CalculateThread(IntegerComm integerComm) {
		this.integerComm = integerComm;
	}
	
	
	@Override
	public void run() {
		for(int i = 0 ; i < 5 ; i++) 
			sum+=integerComm.getSum();
		
		System.out.println("Sum : " + sum);
	}
}
class IntegerComm {
	private int num;
	private boolean newData = false;
	public void setSum(int n) {
		
		synchronized (this) {
			if(newData == true) {
				try {
					wait();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.num = n;
			newData = true;
			notify();
		}
	}
	
	public int getSum() {
		synchronized (this) {
			if(newData == false) {
				try {
					wait();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			newData=false;
			notify();
		}
		return this.num;
	}
}


