package com.hexaware.policymanagement.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.hexaware.policymanagement.entity.User;
import com.hexaware.policymanagement.repository.UserRepository;
/* Author:Devanshu
 * @CreatedOn:-17-11-2023
 * Description: UserDetailsService implementation for AuthorizationT 
 */
@Component
public class UserInfoUserDetailsService implements UserDetailsService 
{

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username)
    {
        User user = repository.findByEmail(username);
        return new UserInfoUserDetails(user);
       
    }
}