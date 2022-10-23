package com.example.spring_lap_5.dao;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.spring_lap_5.entity.ChuyenBay;

@RepositoryRestResource(path = "members")
public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String> {
	
	List<ChuyenBay> findAllBygaden(String gaden);

	

}
