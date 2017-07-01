package com.internship.ticketMonster.delivery;

import java.util.ArrayList;

public class WareHouse {
	private String wName;
	
	private int droneCnt;
	private int deliveryCnt, deliveryTime;
	private ArrayList<String> orderNumList;
	
	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public int getDroneCnt() {
		return droneCnt;
	}

	public void setDroneCnt(int droneCnt) {
		this.droneCnt = droneCnt;
	}

	public int getDeliveryCnt() {
		return deliveryCnt;
	}

	public void setDeliveryCnt(int deliveryCnt) {
		this.deliveryCnt = deliveryCnt;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public ArrayList<String> getOrderNumList() {
		return orderNumList;
	}

	public void setOrderNumList(ArrayList<String> orderNumList) {
		this.orderNumList = orderNumList;
	}

	public WareHouse(String wName, int droneCnt, int deliveryCnt, int deliveryTime) {
		this.wName = wName;
		this.droneCnt = droneCnt;
		this.deliveryCnt = deliveryCnt;
		this.deliveryTime = deliveryTime;
		orderNumList = new ArrayList<String>();
	}
	
	public void deliveryStart(String departure, int dTime) {
		droneCnt -= 1;
		deliveryCnt += 1;
		deliveryTime += dTime;
		orderNumList.add(departure);
	}
	
	public void deliveryEnd(int dTime) {
		droneCnt += 1;
		deliveryTime += dTime;
	}
	
	public boolean checkDroneCnt() {
		if(droneCnt > 0) return true;
		else return false;
	}
}
