package com.example.spring_lap_5.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChungNhanPK implements Serializable {
	private String nhanvien;
	private int maybay;
	
	public ChungNhanPK() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maybay;
		result = prime * result + ((nhanvien == null) ? 0 : nhanvien.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChungNhanPK other = (ChungNhanPK) obj;
		if (maybay != other.maybay)
			return false;
		if (nhanvien == null) {
			if (other.nhanvien != null)
				return false;
		} else if (!nhanvien.equals(other.nhanvien))
			return false;
		return true;
	}

}
