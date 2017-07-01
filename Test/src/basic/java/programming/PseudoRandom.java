package basic.java.programming;

import java.util.Random;
public class PseudoRandom {
	public static void main(String[] args) {
		Random random = new Random(12);
		random.setSeed(System.currentTimeMillis());
		
		for(int i = 0; i < 100; i++)
			System.out.println(random.nextInt(1000));
	}
}
