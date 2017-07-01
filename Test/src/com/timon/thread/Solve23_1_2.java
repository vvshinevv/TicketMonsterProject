package com.timon.thread;

public class Solve23_1_2 {
	public static void main(String[] args) {
		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);
		Thread tr1 = new Thread(at1);
		Thread tr2 = new Thread(at2);
		
		tr1.start(); tr2.start();
		try { tr1.join(); tr2.join(); } catch (InterruptedException e) { e.printStackTrace();}
		System.out.println(at1.getSum() + at2.getSum());
	}
}

class SumRun {
	private int sum;
	public SumRun() { sum = 0; }
	public void addSum(int n) { sum += n; }
	public int getSum() {return sum;}
}

class AdderThread extends SumRun implements Runnable {
	int start, end;
	public AdderThread(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for(int i = start; i <= end; i++)
			addSum(i);
	}
}
