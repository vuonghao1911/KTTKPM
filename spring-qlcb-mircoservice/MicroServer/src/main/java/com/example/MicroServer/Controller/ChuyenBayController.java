package com.example.MicroServer.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MicroServer.entity.ChuyenBay;
import com.example.MicroServer.service.ChuyenBayService;
import com.google.gson.Gson;


@RestController
@RequestMapping("/chuyenbay")
public class ChuyenBayController {
	 private static Gson gson = new Gson();
	@Autowired
	private ChuyenBayService chuyenBayService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	 
	public List<ChuyenBay> getListChuyenBay(){
		List<ChuyenBay> list = chuyenBayService.getListChuyenBay();
		
		
		return list;
	}
	@GetMapping("/{id}")
	public ChuyenBay getChuyenBayById(@PathVariable String id){
		ChuyenBay cb = chuyenBayService.getChuyenBayById(id);
		return cb;
	}
}
