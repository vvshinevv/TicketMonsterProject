package com.internship.ticketMonster.delivery;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DistributeOrder {
	
	private JsonOrders jsonOrders;
	private int[][] leadTimePerLocal;
	private WareHouse[] wareHouses;
	
	public DistributeOrder(JsonOrders jsonOrders, int[][] leadTimePerLocal, int[] droneCnt) {
		this.jsonOrders = jsonOrders;
		this.leadTimePerLocal = leadTimePerLocal;
		this.wareHouses = new WareHouse[(int)leadTimePerLocal.length];
		
		for(int i = 0 ; i < (int)leadTimePerLocal.length; i++) 
			wareHouses[i] = new WareHouse(String.valueOf((char)(i+'A'))+"창고", droneCnt[i], 0, 0);
	}
	
	public void distributeOrder() { // run
		TreeMap<Integer, String> map;
		MakePriorityDeliveryArea makePriorityDeliveryArea = new MakePriorityDeliveryArea(leadTimePerLocal); // 지역별 최소 시간 계산
		
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonOrders.getOrders().toJSONString());
			JSONArray ordersArray = (JSONArray) jsonObject.get("orders");

			for(int i = 0 ; i < ordersArray.size(); i++) {
				
				JSONObject orderObject = (JSONObject) ordersArray.get(i);
				
				int local = Integer.valueOf(orderObject.get("address").toString().substring(0, 1)) - 1; // 배열이 0번부터 시작이라...
				map = makePriorityDeliveryArea.makePriorty(local); // 우선순위가 시간이 적은 순으로 map에 push
				

				for(Map.Entry<Integer, String> entry : map.entrySet()) {
				    Integer leadingTime = entry.getKey();
				    String departureArea = entry.getValue();
				    				    
				    if(wareHouses[(int)(departureArea.charAt(0)-'A')].checkDroneCnt()) { // 드론이 warehouse에 있으면
				    	wareHouses[(int)(departureArea.charAt(0)-'A')].deliveryStart(orderObject.get("orderNo").toString(), leadingTime); // 갔다가
				    	wareHouses[(int)(departureArea.charAt(0)-'A')].deliveryEnd(leadingTime); // 돌아옴
				    
				    	break;
				    }
				}
			}
		} catch (Exception e) { e.printStackTrace(); }
	}
	
	public void printDeliveryLayout() {
		
		for(int i = 0 ; i < (int)wareHouses.length; i++) {
			System.out.println(wareHouses[i].getwName());
			System.out.println("주문 처리 건수 " + wareHouses[i].getDeliveryCnt() + "건");
			System.out.println("예상 소요 시간: " + wareHouses[i].getDeliveryTime() + "분");
			
			Iterator<String> iterator = wareHouses[i].getOrderNumList().iterator();
			while(iterator.hasNext())
				System.out.println(iterator.next());
				
			System.out.println("=====================");
			System.out.println("");
		}
	}
	
}
