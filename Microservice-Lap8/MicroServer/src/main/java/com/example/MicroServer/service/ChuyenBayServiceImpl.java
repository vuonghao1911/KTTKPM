package com.example.MicroServer.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.MicroServer.entity.ChuyenBay;
import com.google.gson.Gson;

@Service
public class ChuyenBayServiceImpl implements ChuyenBayService {
	static final String URL_API = "http://localhost:8990/chuyenbay/";
	private static Gson gson = new Gson();

    private static RestTemplate restTemplate = new RestTemplate();
    ;




	@Override
	public List<ChuyenBay> getListChuyenBay() {
//		ResponseEntity<List<ChuyenBay>> response = restTemplate.exchange(URL_API, HttpMethod.GET,null,new ParameterizedTypeReference<List<ChuyenBay>>() {
//		});
//		List<ChuyenBay> list = response.getBody();
//		return list;
		Object[] chuyenbays = restTemplate.getForEntity(URL_API, Object[].class).getBody();
        List<ChuyenBay> arr = new ArrayList<>();
        for (Object item : chuyenbays) {
            arr.add(gson.fromJson(gson.toJson(item), ChuyenBay.class));
        }
        return arr;
    }
		
	


	@Override
	public ChuyenBay getChuyenBayById(String id) {
		ChuyenBay	cb = restTemplate.getForObject(URL_API+id, ChuyenBay.class);
		return cb;
	}
	@Override
	 public String getString() {
		String	cb = restTemplate.getForObject("http://hello-service/hello/", String.class);
					
		return cb;
	}

}
