package com.example.RedisDemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RedisDemo.entity.User;
import com.google.gson.Gson;

@RestController
@RequestMapping("/redis")
public class RedisController {
	static Gson gson = new Gson();
	@Autowired
	private RedisTemplate<String, User> redisTemplate;
	@PostMapping("/userhash")
	public User saveUser(@RequestBody User user) {
		
		//redisTemplate.opsForValue().set(user.getId(), user);
		redisTemplate.opsForHash().put("User", user.getId(), user);
		System.out.println("user"+user);
		 return user;
	}
	
	@PostMapping("/uservalue")
	public User saveUserValue(@RequestBody User user) {
		
		redisTemplate.opsForValue().set(user.getId(), user);
//		redisTemplate.opsForHash().put("User", user.getId(), user);
		System.out.println("user"+user);
		 return user;
	}
	@GetMapping("/uservalue/{id}")
	public User getUserValue(@PathVariable("id") String id) {
		
//		
		 return redisTemplate.opsForValue().get(id);
	}
	@GetMapping("/userhash/{id}")
	public Object findById(@PathVariable("id") String id) {
	    return  redisTemplate.opsForHash().get("User", id);
	}
	@GetMapping("/listuser")
	public Map<Object, Object> getlist() {
	    return  redisTemplate.opsForHash().entries("User");
	}
	
	@DeleteMapping("/uservalue/{id}")
	public Boolean deleteUser( @PathVariable("id") String id) {
	    return  redisTemplate.delete(id);
	}
	@DeleteMapping("/userhash/{id}")
	public String deleleUseHash(@PathVariable("id") String id) {
		
		redisTemplate.opsForHash().delete("User", id);
	    
		return  "Delete user id: "+id +"completed";
	}
	
}
