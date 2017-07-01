package basic.java.programming;

import java.util.Scanner;

public class LateRate {
	protected static final double LATE_RATE = 0.66;
	protected static double totalRate; 
	
	public static void main(String[] args) {
		LateRate wr = new LateRate();
		Scanner sc = new Scanner(System.in);
		System.out.println("나졸려씨의 출근횟수를 입력하세요:");
		int count=sc.nextInt();
		  
		wr.checkLate(count,1,0);
		double result = Double.parseDouble(String.format("%.3f", (1-totalRate)));
		  
		System.out.println("나졸려씨가 혼나지 않을 확률은: "+(result*100)+"%");
	}
	 public void checkLate(int count, double thisRate, int index) {
		System.out.println(count+"번째 : "+Double.parseDouble(String.format("%.3f", thisRate)));
		System.out.println("토탈: "+Double.parseDouble(String.format("%.3f", totalRate)));
		
		if(index==3){//3연속 지각했을 때
			totalRate+=thisRate;
			index=0;
			return;
		}
		
		if(count==0){
			return;
		}
		  
		//이번에 지각 했을 때
		checkLate(count-1,thisRate*LATE_RATE,index+1);
		//이번에 지각 안했을 때면 그전에 2일연속 지각했다 하더라도 다시 지각체크를 해야하므로 index=0
		checkLate(count-1,thisRate*(1-LATE_RATE),0);
		 
	 }
}