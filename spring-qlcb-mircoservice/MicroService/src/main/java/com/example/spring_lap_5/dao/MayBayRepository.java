package com.example.spring_lap_5.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_lap_5.entity.MayBay;

public interface MayBayRepository extends JpaRepository<MayBay, Long> {
	 List<MayBay> findAllBytambayGreaterThan(int km);

	
}
