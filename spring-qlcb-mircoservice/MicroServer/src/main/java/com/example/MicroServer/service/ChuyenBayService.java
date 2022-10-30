package com.example.MicroServer.service;

import java.util.List;

import com.example.MicroServer.entity.ChuyenBay;

public interface ChuyenBayService  {
	List<ChuyenBay> getListChuyenBay();
	ChuyenBay getChuyenBayById(String id);

}
