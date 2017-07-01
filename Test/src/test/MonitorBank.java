package test;

public class MonitorBank {

	public static void main(String[] args) throws InterruptedException {
		BankAccountMonitor  b = new BankAccountMonitor();
		ParentMonitor p = new ParentMonitor(b);
		ChildMonitor c = new ChildMonitor(b);
		p.start(); c.start();
		p.join(); c.join();
		System.out.println("");
		System.out.println(b.getBalance());
	}
}

class ParentMonitor extends Thread {
	BankAccountMonitor  b;
	public ParentMonitor(BankAccountMonitor b) {
		this.b = b;
	}
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i++)
			b.deposite(1000);
	}
}

class ChildMonitor extends Thread {
	BankAccountMonitor b;
	public ChildMonitor(BankAccountMonitor b) {
		this.b = b;
	}
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i++)
			b.withdraw(1000);
	}
}

class BankAccountMonitor {
	int balance;
	boolean pTurn = true;
	synchronized void deposite(int amt) {
		int temp = balance + amt;
		System.out.print("+");
		balance = temp; 
		pTurn = false;
		notify();  
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	synchronized void withdraw(int amt) {
		if(balance == 0)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		int temp = balance - amt;
		System.out.print("-");
		balance = temp;
		pTurn = true;
		notify();
	}
	int getBalance() {
		return balance;
	}
}
