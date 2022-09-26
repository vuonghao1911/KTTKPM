package com.example.spring_lap_5.controller;

import java.util.List;

import javax.persistence.Access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_lap_5.dao.ChuyenBayRepository;
import com.example.spring_lap_5.dao.MayBayRepository;
import com.example.spring_lap_5.entity.ChuyenBay;
import com.example.spring_lap_5.entity.MayBay;


@RestController
@RequestMapping("/chuyenbay")
public class ChuyenBayController {

	@Autowired
	private ChuyenBayRepository chuyenBayRepository;
	@Autowired 
	private MayBayRepository mayBayRepository;
	
	@GetMapping("/noiden")
	public List<ChuyenBay> getChuyenBayByNoiDen() {
		List<ChuyenBay> list= chuyenBayRepository.findAllBygaden("DAD");
		return list;
		
	}
	@GetMapping("/loaimb")
	public List<MayBay> getLoaiMBByTamBay(){
		List<MayBay> list = mayBayRepository.findAllBytambayGreaterThan(10000);
		return list;
	}
}
