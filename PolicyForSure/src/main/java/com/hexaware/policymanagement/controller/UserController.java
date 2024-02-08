package com.hexaware.policymanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.policymanagement.dto.UserDTO;
import com.hexaware.policymanagement.entity.User;
import com.hexaware.policymanagement.services.IUserServices;
import com.hexaware.policymanagement.services.JwtService;
/* Author:Devanshu
 * @CreatedOn:-15-11-2023
 * Description: Address Controller Class
 */
/* Author:Devanshu/VidhyaMalathi
 * @UpdatedOn:-17-11-2023
 * Description: Assigned Authority
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/users")
public class UserController 
{
	@Autowired
	IUserServices service;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping(value = "/add")
	public User createUser(@RequestBody UserDTO userDTO)
	{
		return service.createUser(userDTO);
	}
	
	
	@PutMapping(value = "/update")
    @PreAuthorize("hasAnyAuthority('Admin','User')")
	public User updateUser(@RequestBody UserDTO userDTO)
	{
		return service.updateUser(userDTO);
	}
	
	
	@DeleteMapping(value = "/delete/{userId}")
	@PreAuthorize("hasAuthority('Admin')")
	public void deleteByUserId(@PathVariable long userId)
	{
		service.deleteByUserId(userId);
	}
	
	
	@GetMapping(value = "/getall",produces = "application/json")
	@PreAuthorize("hasAuthority('Admin')")
	public List<User> getAllUser()
	{
		return service.getAllUser();
		
	}
	
	
	@GetMapping(value = "/get/mobile/{mobNo}")
	@PreAuthorize("hasAuthority('Admin')")
	public User getUserByMobNo(@PathVariable String mobNo)
	{
		return service.getUserByMobNo(mobNo);
		
	}
	
	@GetMapping(value = "/get/id/{userId}")
    @PreAuthorize("hasAnyAuthority('Admin','User')")
	public Optional<User> getUserById(@PathVariable long userId)
	{
		return service.getById(userId);
		
	}
	
	@GetMapping(value = "/get/email/{email}")
    @PreAuthorize("hasAnyAuthority('Admin','User')")
	public UserDTO getUserPolicyByEmail(@PathVariable String email)
	{
		return service.getUserByEmail(email);
		
	}
	
	@GetMapping(value = "/get/type/{userType}")
	@PreAuthorize("hasAuthority('Admin')")
	public List<User> getUserByUserType(@PathVariable String userType)
	{
		return service.getUserByUserType(userType);
		
	}
	
	@GetMapping(value = "/get/category/{userCategory}")
	@PreAuthorize("hasAuthority('Admin')")
	public List<User> getUserByUserCategory(@PathVariable String userCategory)
	{
		return service.getUserByUserCategory(userCategory);
		
	}
	
	@GetMapping("/sendmailregistration/{userId}")
	
	public boolean successRegistration(@PathVariable long userId) {
		System.out.print(userId);
		System.out.println("uday");
		service.sendEmailRegistration(userId);
		return true;
	}

}
