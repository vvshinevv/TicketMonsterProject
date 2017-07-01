package test;

class PhilosopherMonitor {
	static final int num = 5;
	public static void main(String[] args) {
		
		Chopstick[] stick = new Chopstick[num];
		 
		for(int i = 0 ; i<num; i++) 
			stick[i] = new Chopstick();
			
		Test00[] phil = new Test00[num];
		for(int i = 0 ; i < num ; i++) 
			phil[i] = new Test00(i, stick[i], stick[(i+1) % num]);
		
		for(int i = 0 ; i < num ; i++) 
			phil[i].start();
	}
}


class Chopstick {
	private boolean inUse = false;
	synchronized void acquired() throws InterruptedException {
		if(inUse)
			wait();
		
		inUse = true;
	}
	
	synchronized void release() {
		inUse = false;
		notify();
	}
}

class Test00 extends Thread {
	
	int id;
	Chopstick lstick, rstick;
	
	public Test00(int id, Chopstick lstick, Chopstick rstick) {
		this.id = id;
		this.lstick = lstick;
		this.rstick = rstick;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				lstick.acquired();
				rstick.acquired();
				eating();
				rstick.release();
				lstick.release();
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

