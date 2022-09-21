package com.example.spring_lap_5.entity;

public class NhanVien {
	private String manv;
	private String ten;
	private int luong;
	public NhanVien(String maNV, String tenNV, int luong) {
		super();
		this.manv = maNV;
		this.ten = tenNV;
		this.luong = luong;
	}
	public String getManv() {
		return manv;
	}
	public void setMaNV(String maNV) {
		this.manv = maNV;
	}
	public String getTen() {
		return ten;
	}
	public void setTenNV(String tenNV) {
		this.ten = tenNV;
	}
	public int getLuong() {
		return luong;
	}
	public void setLuong(int luong) {
		this.luong = luong;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + manv + ", tenNV=" + ten + ", luong=" + luong + "]";
	}
	
	
}
