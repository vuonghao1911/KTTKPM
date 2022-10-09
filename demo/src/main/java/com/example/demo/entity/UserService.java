package com.example.demo.entity;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.jwt.JwtAuthenticationFilter;
import com.example.demo.jwt.JwtTokenProvider;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenProvider tokenProvider;


    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByUserName(username);
        if (user == null) {
            return null;
        }
        return new CustomUserDetails(user);
    }
    
    @Transactional
   public UserDetails getUserById(Long id) {
	   User user = userRepository.findById(id).orElseThrow(
               () -> new UsernameNotFoundException("User not found with id : " + id)
       );

       return new CustomUserDetails(user);
   }
    
//    public UserDetails getUserByJwt(HttpServletRequest request) {
//    	String jwt = authenticationFilter.getJwtFromRequest(request);
//    	 if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
//             // Lấy id user từ chuỗi jwt
//             Long userId = tokenProvider.getUserIdFromJWT(jwt);
//             // Lấy thông tin người dùng từ id
//             UserDetails userDetails = this.getUserById(userId);
//             if(userDetails != null) {
//            	 	return userDetails;
//            	 
//            	 }
//             
//             }
//    	 return null;
//    }

    }



