package com.example.spring_lap_5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "maybay")
public class MayBay {
	@Id
	@Column(name = "ma_mb")
	private int mamb;
	@Column(name = "loai")
	private String loai;
	@Column(name = "tam_bay")
	private int tambay;
	public MayBay() {
		
	}
	public MayBay(int mamb, String loai, int tambay) {
		super();
		this.mamb = mamb;
		this.loai = loai;
		this.tambay = tambay;
	}
	public int getMamb() {
		return mamb;
	}
	public void setMamb(int mamb) {
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
