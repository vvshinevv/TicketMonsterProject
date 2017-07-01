package com.internship.ticketMonster.delivery;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonOrders {
	
	private static final int startOrderNum = 1234;
	private static final int endOrderNum = 1334;
	private JSONObject jsonObject;
	private JSONArray orderArray;
	private JSONObject orderObject;
	
	public JsonOrders() {
		jsonObject = new JSONObject();
		orderArray = new JSONArray();
	}
	
	public void makeJsonOrder() {
		// 주문서 임의로 만들기
		for(int i = startOrderNum; i < endOrderNum; i++) {
			orderObject = new JSONObject();
			orderObject.put("orderNo", String.valueOf(i));
			orderObject.put("address", ((int)(Math.random() * 5 + 1))+ "번지역");
			
			orderArray.add(orderObject);
		}
		jsonObject.put("orders", orderArray);
		
		System.out.println(jsonObject.toJSONString());
	}
	
	public JSONObject getOrders() {		
		return jsonObject;	
	}
}
