package com.example.RedisDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RedisDemo.entity.User;

@RestController
@RequestMapping("/redis")
public class RedisController {
	@Autowired
	private RedisTemplate redisTemplate;
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		 redisTemplate.opsForValue().set(user.getId(),user);
		 return user;
	}
}
