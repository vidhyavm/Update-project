package com.hexaware.policymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.policymanagement.dto.AuthRequest;
import com.hexaware.policymanagement.dto.LoginResponse;
import com.hexaware.policymanagement.repository.UserRepository;
import com.hexaware.policymanagement.services.JwtService;
/* Author:Devanshu
 * @CreatedOn:-17-11-2023
 * Description: Login Controller (With User Authentication)
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
	
	@Autowired
	UserRepository user;

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    

    public LoginController
    (
            AuthenticationManager authenticationManager,
            JwtService jwtService)
            
    {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        
    }

    @PostMapping("/user")
    public LoginResponse userLogin(@RequestBody AuthRequest authRequest) 
    {
    	LoginResponse response = new LoginResponse();
        authenticate(authRequest.getUsername(), authRequest.getPassword());

        String token = jwtService.generateToken(authRequest.getUsername());
        String type = user.findUserTypeByEmail(authRequest.getUsername());
        String userId = user.findUserIdByEmail(authRequest.getUsername());
        String userName = user.findUserNameByEmail(authRequest.getUsername());

        
        response.setToken(token);
        response.setUserId(userId);
        response.setUserType(type);
        response.setUserName(userName);
        
        return response;
    }

    private void authenticate(String username, String password) 
    {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        if (!authenticate.isAuthenticated()) 
        {
            throw new UsernameNotFoundException("Invalid Username or Password / Invalid request");
        }
    }
}