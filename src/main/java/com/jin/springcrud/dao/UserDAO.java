package com.jin.springcrud.dao;

import com.jin.springcrud.entity.User;

public interface UserDAO {

    public User findByUserName(String userName);
    public void save(User user);
    
}