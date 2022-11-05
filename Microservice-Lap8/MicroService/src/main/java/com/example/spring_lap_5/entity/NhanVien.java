package com.example.spring_lap_5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
	@Id
	@Column(name = "ma_nv")
	private String manv;
	@Column(name = "ten")
	private String ten;
	@Column(name = "luong")
	private int luong;
	public NhanVien() {
		
	}
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
