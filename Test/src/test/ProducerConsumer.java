package test;

import java.util.concurrent.Semaphore;

public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		Buffer b= new Buffer(100);
		Producer p = new Producer(b, 90000);
		Consumer c = new Consumer(b, 90000);
		p.start(); c.start();
		p.join(); c.join();
		System.out.println(b.count);
	}

}

class Buffer {
	int[] buf;
	int size;
	int count;
	int in;
	int out;

	Semaphore mutexS, emptyS, fullS;
	
	Buffer(int size) {
		buf = new int[size];
		this.size = size;
		count = in = out = 0;
		mutexS = new Semaphore(1);
		emptyS = new Semaphore(size);
		
		fullS = new Semaphore(0);
	}
	
	void insert(int item) {
		//while(count == size)
		
		try{
			//emptyS.acquire();
			///////////////////////////
			//mutexS.acquire();
			buf[in] = item;
			in = (in+1) % size;
			System.out.print("+");
			count++;
			//mutexS.release();
			///////////////////////////
			//fullS.release();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void remove() {
		//while(count == 0)
		try{
			//fullS.acquire();
			///////////////////////////
			//mutexS.acquire();
			out = (out+1) % size;
			System.out.print("-");
			count--;
			//mutexS.release();
			///////////////////////////
			//emptyS.release();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class Producer extends Thread{
	Buffer b;
	int N;
	Producer(Buffer b, int N) {
		this.b = b; this.N= N;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < N; i++) {
			b.insert(i);
		}
	}
	
}

class Consumer extends Thread {
	Buffer b;
	int N;
	
	Consumer(Buffer b, int N) {
		this.b = b; this.N= N;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < N; i++) {
			b.remove();
		}
	}
	
}