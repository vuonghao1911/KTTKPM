package com.example.spring_lap_5.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(ChungNhanPK.class)
@Table(name = "chungnhan")
public class ChungNhan {
	@Id
	@ManyToOne
	@JoinColumn(name = "ma_nv")
	private NhanVien nhanvien;
	@Id
	@ManyToOne
	@JoinColumn(name="ma_mb")
	private  MayBay maybay;
	
	public ChungNhan() {
		
	}

	public ChungNhan(NhanVien nhanvien, MayBay maybay) {
		super();
		this.nhanvien = nhanvien;
		this.maybay = maybay;
	}

	public NhanVien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public MayBay getMaybay() {
		return maybay;
	}

	public void setMaybay(MayBay maybay) {
		this.maybay = maybay;
	}
	
	
	
}
