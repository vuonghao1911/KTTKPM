package com.example.spring_lap_5.entity;

public class ChungNhan {
	private String manv;
	private  int mamb;
	public ChungNhan(String manv, int mamb) {
		super();
		this.manv = manv;
		this.mamb = mamb;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public int getMamb() {
		return mamb;
	}
	public void setMamb(int mamb) {
		this.mamb = mamb;
	}
	@Override
	public String toString() {
		return "ChungNhan [manv=" + manv + ", mamb=" + mamb + "]";
	}
	
	
}
