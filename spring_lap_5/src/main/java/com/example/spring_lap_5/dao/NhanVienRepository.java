package com.example.spring_lap_5.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_lap_5.entity.NhanVien;

public interface NhanVienRepository extends JpaRepository<NhanVien, String>{
	 List<NhanVien> findAllByluongLessThan(int luong);
}
