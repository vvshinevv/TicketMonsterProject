package test;
import java.util.concurrent.Semaphore;

public class Bank {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BankAccount ba = new BankAccount();
		Parent p = new Parent(ba);
		Child c = new Child(ba);
		p.start(); c.start(); p.join(); c.join();
		System.out.println(ba.getAccount());
		
	}

}
class Parent extends Thread {
	BankAccount b;
	Parent(BankAccount b) {this.b = b;}
	public void run() {
		try {
		for(int i = 0; i<1000; i++) {b.deposit(1000);}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Child extends Thread {
	BankAccount b;
	Child(BankAccount b) {this.b = b;}
	public void run() {
		try {
		for(int i = 0; i<1000; i++) {b.withdraw(1000);}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class BankAccount {
	Semaphore semaphore;
	int balance;
	//Semaphore semaphore2;
	Semaphore dSemaphore;
	Semaphore wSemaphore;
	public BankAccount() {
		semaphore = new Semaphore(1);
		dSemaphore = new Semaphore(0);
		wSemaphore = new Semaphore(0);
		//semaphore2 = new Semaphore(0);
	}
	void deposit(int n) throws InterruptedException {
		//semaphore2.acquire();
		dSemaphore.acquire();
		/////////////////////////////
		semaphore.acquire();
		int temp = balance + n;
		System.out.print("+");
		balance = temp;
		semaphore.release();
		/////////////////////////////	
		wSemaphore.release();
		
		
		
	}
	void withdraw(int n) throws InterruptedException {
		
		/////////////////////////////
		semaphore.acquire();
		int temp = balance - n;
		System.out.print("-");
		balance = temp;
		semaphore.release();
		/////////////////////////////
		//semaphore2.release();
		dSemaphore.release();
		wSemaphore.acquire();
		
	}
	int getAccount() {
		return balance; 
	}
}