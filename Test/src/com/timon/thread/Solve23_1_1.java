package com.timon.thread;

public class Solve23_1_1 {

	public static void main(String[] args) {
		Sum sum = new Sum();
		AddThread at1 = new AddThread(sum, 1, 50);
		AddThread at2 = new AddThread(sum, 51, 100);
		
		at1.start(); at2.start();
		try{
			at1.join(); at2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(sum.getNum());
	}
}

class Sum {
	private int num;
	public Sum() {num=0;}
	public void addNum(int n) {num+=n;}
	public int getNum() {return num;}
}

class AddThread extends Thread {
	private int start, end;
	private Sum sum;
	public AddThread(Sum sum, int start, int end) {
		this.sum = sum;
		this.start = start; 
		this.end = end;
	}
	
	@Override
	public void run() {
		for(int i = start; i <= end; i++ )
			sum.addNum(i);
	}
	
}
