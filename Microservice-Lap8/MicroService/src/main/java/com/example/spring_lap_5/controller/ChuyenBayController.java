package com.example.spring_lap_5.controller;

import java.util.List;

import javax.persistence.Access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.spring_lap_5.dao.ChuyenBayRepository;
import com.example.spring_lap_5.dao.MayBayRepository;
import com.example.spring_lap_5.dao.NhanVienRepository;
import com.example.spring_lap_5.dao.OrderRepository;
import com.example.spring_lap_5.entity.ChuyenBay;
import com.example.spring_lap_5.entity.MayBay;
import com.example.spring_lap_5.entity.NhanVien;
import com.example.spring_lap_5.entity.Order;


@RestController
@RequestMapping("/")
public class ChuyenBayController {

	@Autowired
	private ChuyenBayRepository chuyenBayRepository;
	@Autowired 
	private MayBayRepository mayBayRepository;
	@Autowired 
	private NhanVienRepository nhanVienRepository;
	@Autowired
	private OrderRepository orderRepository;

	
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
	@GetMapping("/nhanvienluong")
	public List<NhanVien> getNhanVienByLuong(){
		List<NhanVien> list =  nhanVienRepository.findAllByluongLessThan(10000);
		return list;
	}
		@GetMapping("/")
	public String demo() {
		return "ok";
	}
	
	  
}

