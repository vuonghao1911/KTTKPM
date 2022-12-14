package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.engine.query.spi.sql.NativeSQLQueryCollectionReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CustomUserDetails;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRepository;
import com.example.demo.entity.UserService;
import com.example.demo.jwt.JwtAuthenticationFilter;
import com.example.demo.jwt.JwtTokenProvider;
import com.example.demo.mqservice.ProducerService;
import com.example.demo.payload.LoginRequest;
import com.example.demo.payload.LoginResponse;
import com.example.demo.payload.RandomStuff;
import com.example.demo.service.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;


//
import ch.qos.logback.core.net.LoginAuthenticator;

@RestController
@RequestMapping()
public class LodaRestController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;
    @Autowired
    ProducerService producerService;
    

    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
	private JwtAuthenticationFilter authenticationFilter;
    
    @PostMapping(value = "/register")
    public User Register( @Valid @RequestBody LoginRequest loginRequest) {
    		System.out.println("user: "+loginRequest);
            User user = new User();
          user.setUserName(loginRequest.getUsername());
          user.setPassWord(passwordEncoder.encode(loginRequest.getPassword()));
          UserDetails userDetails = userService.loadUserByUsername(user.getUserName());
          System.out.println("details "+userDetails);
          if(userDetails!=null) {
        	  return new User("Loi", "Loi");
          }else {
			
		
        	userRepository.save(user);
        	System.out.println("new user"+user);

//        
        return user;
        }
    }

    @PostMapping(value = "/login", 	consumes = "application/json")
    public String authenticateUser( @Valid @RequestBody LoginRequest loginRequest) {
    		System.out.println("user: "+loginRequest);
            User user = new User();
          user.setUserName(loginRequest.getUsername());
          user.setPassWord(passwordEncoder.encode(loginRequest.getPassword()));
        
		
      //  userRepository.save(user);
          System.out.println("new user"+user);

//         X??c th???c t??? username v?? password.
    		Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
        // N???u kh??ng x???y ra exception t???c l?? th??ng tin h???p l???
        // Set th??ng tin authentication v??o Security Context
        SecurityContextHolder.getContext().setAuthentication((org.springframework.security.core.Authentication) authentication);

        // Tr??? v??? jwt cho ng?????i d??ng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) ((org.springframework.security.core.Authentication) authentication).getPrincipal());
          
        return "jwt"+ jwt;
        
    }

    // Api /api/random y??u c???u ph???i x??c th???c m???i c?? th??? request
    @GetMapping("/random")
    public String randomStuff(){
    	//System.out.println("dat");
    	return "JWT H???p l??? m???i c?? th??? th???y ???????c message n??y";
    }
    @GetMapping("/user")
    public UserDetails getUserByJwt(HttpServletRequest request) {
    	
    	
        	String jwt = authenticationFilter.getJwtFromRequest(request);
        	 if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                 // L???y id user t??? chu???i jwt
                 Long userId = tokenProvider.getUserIdFromJWT(jwt);
                 // L???y th??ng tin ng?????i d??ng t??? id
                 UserDetails userDetails =  userService.getUserById(userId);
                 if(userDetails != null) {
                	 	return userDetails;
                	 
                	 }
                 
                 }
        	 return null;
        
    }
    @PostMapping("/mess")
    public Order sendMess( @RequestBody Order  order) throws JsonProcessingException {
    		
    	producerService.sendToTopic("myTopic",  order);
    	
    	
    	return  order;
    	
    }
    
//    @PostMapping("/saveorder")
//    public Order addOrder(@RequestBody Order order) {
//    	
//    	try {
//			 orderRepository.save(order);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	
//    	return order;
//    }
//    @GetMapping
//    public List<Order> getOrder() {
//    	List<Order> list = orderRepository.findAll();
//    	return list;
//		
//	}
    
    
    

}
