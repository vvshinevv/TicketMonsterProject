package test;

import java.util.concurrent.Semaphore;

class Philosopher {
	static final int num = 5;
	public static void main(String[] args) {
		
		Semaphore[] stick = new Semaphore[num];
		 
		for(int i = 0 ; i<num; i++) 
			stick[i] = new Semaphore(1);
			
		Test[] phil = new Test[num];
		for(int i = 0 ; i < num ; i++) 
			phil[i] = new Test(i, stick[i], stick[(i+1) % num]);
		
		for(int i = 0 ; i < num ; i++) 
			phil[i].start();
	}
}
class Test extends Thread {
	
	int id;
	Semaphore lstick, rstick;
	
	public Test(int id, Semaphore lstick, Semaphore rstick) {
		this.id = id;
		this.lstick = lstick;
		this.rstick = rstick;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				if(id%2 == 0) {
					lstick.acquire();
					rstick.acquire();
				} else {
					rstick.acquire();
					lstick.acquire();
				}
				eating();
				lstick.release();
				rstick.release();
				thinking();
			}
		}catch(InterruptedException e) {}
	}
	
	void eating() {
		System.out.println("["+id+"] eating");
	}
	
	void thinking() {
		System.out.println("["+id+"] thinking");
	}
}
