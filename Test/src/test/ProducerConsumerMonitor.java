package test;

public class ProducerConsumerMonitor {

	public static void main(String[] args) throws InterruptedException {
		BufferMonitor b= new BufferMonitor(100);
		ProducerMonitor p = new ProducerMonitor(b, 10000);
		ConsumerMonitor c = new ConsumerMonitor(b, 10000);
		p.start(); c.start();
		p.join(); c.join();
		System.out.println(b.count);
	}

}

class BufferMonitor {
	int[] buf;
	int size;
	int count;
	int in;
	int out;

	BufferMonitor(int size) {
		buf = new int[size];
		this.size = size;
		count = in = out = 0;
	}
	
	synchronized void insert(int item) {
		if(count == size) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		buf[in] = item;
		in = (in+1) % size;
		count++;
		notify();
	}
	synchronized int remove() {
		if(count == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int item = buf[out];
		out = (out+1) % size;
		count--;
		notify();
		return item;
	}
}

class ProducerMonitor extends Thread{
	BufferMonitor b;
	int N;
	ProducerMonitor(BufferMonitor b, int N) {
		this.b = b; this.N= N;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < N; i++) {
			b.insert(i);
		}
	}
}

class ConsumerMonitor extends Thread {
	BufferMonitor b;
	int N;
	
	ConsumerMonitor(BufferMonitor b2, int N) {
		this.b = b2; this.N= N;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < N; i++) {
			b.remove();
		}
	}
}
