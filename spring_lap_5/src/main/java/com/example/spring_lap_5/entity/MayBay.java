package com.example.spring_lap_5.entity;

public class MayBay {
	private String mamb;
	private String loai;
	private int tambay;
	public MayBay(String mamb, String loai, int tambay) {
		super();
		this.mamb = mamb;
		this.loai = loai;
		this.tambay = tambay;
	}
	public String getMamb() {
		return mamb;
	}
	public void setMamb(String mamb) {
		this.mamb = mamb;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public int getTambay() {
		return tambay;
	}
	public void setTambay(int tambay) {
		this.tambay = tambay;
	}
	@Override
	public String toString() {
		return "MayBay [mamb=" + mamb + ", loai=" + loai + ", tambay=" + tambay + "]";
	}
	
}
