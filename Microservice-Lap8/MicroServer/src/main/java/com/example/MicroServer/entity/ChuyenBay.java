package com.example.MicroServer.entity;

import java.io.Serializable;
import java.util.Date;


public class ChuyenBay implements Serializable {
	
	private String macb;
	
	private String gadi;
	
	private String gaden;
	
	private int dodai;
	
	private Date giodi;
	
	private Date gioden;
	
	private int chiphi;
	public ChuyenBay() {
		
	}
	public ChuyenBay(String macb, String gadi, String gaden, int dodai, Date giodi, Date gioden, int chiphi) {
		super();
		this.macb = macb;
		this.gadi = gadi;
		this.gaden = gaden;
		this.dodai = dodai;
		this.giodi = giodi;
		this.gioden = gioden;
		this.chiphi = chiphi;
	}
	public String getMacb() {
		return macb;
	}
	public void setMacb(String macb) {
		this.macb = macb;
	}
	public String getGadi() {
		return gadi;
	}
	public void setGadi(String gadi) {
		this.gadi = gadi;
	}
	public String getGaden() {
		return gaden;
	}
	public void setGaden(String gaden) {
		this.gaden = gaden;
	}
	public int getDodai() {
		return dodai;
	}
	public void setDodai(int dodai) {
		this.dodai = dodai;
	}
	public Date getGiodi() {
		return giodi;
	}
	public void setGiodi(Date giodi) {
		this.giodi = giodi;
	}
	public Date getGioden() {
		return gioden;
	}
	public void setGioden(Date gioden) {
		this.gioden = gioden;
	}
	public int getChiphi() {
		return chiphi;
	}
	public void setChiphi(int chiphi) {
		this.chiphi = chiphi;
	}

	
}
