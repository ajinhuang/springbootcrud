package com.jin.springcrud.service;

import com.jin.springcrud.entity.User;
import com.jin.springcrud.security.validation.CrmUser;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
