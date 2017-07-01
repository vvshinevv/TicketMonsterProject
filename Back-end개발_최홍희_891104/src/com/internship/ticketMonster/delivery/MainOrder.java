package com.internship.ticketMonster.delivery;

public class MainOrder {

	public static void main(String[] args) {
		int [][]	leadTimePerLocal = new int[][] {
			{10, 25, 30, 50, 60},
			{20, 10, 20, 40, 55},
			{60, 40, 25, 15, 20},
			{30, 30, 40, 25, 10}
		};
		int [] droneCnt = new int[]{20, 25, 15, 30 };
		
		JsonOrders jsonOrders = new JsonOrders();
		//배송 주문서 만들기
		jsonOrders.makeJsonOrder();
		
		DistributeOrder distributeOrder = new DistributeOrder(jsonOrders, leadTimePerLocal, droneCnt); // 주문서 각 warehouse로 분배하기 객체 생성
		distributeOrder.distributeOrder(); // 분배
		distributeOrder.printDeliveryLayout(); // 분배 내역 출력
	}

}
